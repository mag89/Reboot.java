package ru.tax.statementToReport.converter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.tax.statementToReport.dto.StatementDto;
import ru.tax.statementToReport.exceptions.InvalidTypeException;
import ru.tax.statementToReport.exceptions.SheetDoesNotExistException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class ExcelFileConverter implements Converter {

    @Override
    public StatementDto convertToStatementDto(String excelFileREF, FileTypes type, int sheetNum) throws IOException {
        File inputExcelFile = new File(excelFileREF);
        FileInputStream fileInputStream = new FileInputStream(inputExcelFile);
        Workbook workbook;
        Sheet workbookSheet;
        switch (type) {
            case XLS: {
                workbook = new HSSFWorkbook(fileInputStream);
                workbookSheet = workbook.getSheetAt(sheetNum);
                break;
            }
            case XLSX: {
                workbook = new XSSFWorkbook(fileInputStream);
                workbookSheet = workbook.getSheetAt(sheetNum);
                break;
            }
            default:
                throw new InvalidTypeException("Unknown file type: " + type);
        }

        Optional<Sheet> optionalSheet = Optional.ofNullable(workbookSheet);
        Pattern budgetClassificationCodePattern = Pattern.compile("182\\d{17}");
        ArrayList<Double> charge;
        Map<String, ArrayList<Double>> states = new HashMap<>();

        for (Row row : optionalSheet.orElseThrow(SheetDoesNotExistException::new)) {
            // TODO refactor row.getCell(0)==null to Optional? How?
            if (row.getCell(0) == null) {
                continue;
            }

            Cell valueCell0 = row.getCell(0);
            String stringCell0 = valueCell0 + "";
            if (budgetClassificationCodePattern.matcher(stringCell0).find()) {
                setCellNumericValueIfNot(row, 1);
                setCellNumericValueIfNot(row, 2);
                boolean isZeroCell3 = setCellNumericValueIfNot(row, 3) == 0.0;
                boolean isZeroCell4 = setCellNumericValueIfNot(row, 4) == 0.0;
                boolean isZeroCell5 = setCellNumericValueIfNot(row, 5) == 0.0;
                boolean isZeroCell6 = setCellNumericValueIfNot(row, 6) == 0.0;
                boolean isZeroCell7 = setCellNumericValueIfNot(row, 7) == 0.0;

                if (!isZeroCell3 || !isZeroCell4 || !isZeroCell5 || !isZeroCell6 || !isZeroCell7) {

                    charge = new ArrayList<>(7);
                    for (int i = 1; i <= 7; i++) {
                        charge.add(Optional.ofNullable(row.getCell(i)).map(Cell::getNumericCellValue).orElse(0.0));
                    }
                    states.put(stringCell0, charge);
                }
            }
        }

        String sheetName = workbook.getSheetName(sheetNum);
        StatementDto statementDto = new StatementDto(states, sheetName);
        workbook.close();
        fileInputStream.close();

        return statementDto;
    }

    private double setCellNumericValueIfNot(Row row, int cellNumber) {
        double cellNumericValue;
        try {
            cellNumericValue = Optional.ofNullable(row.getCell(cellNumber)).map(Cell::getNumericCellValue).orElse(0.0);
        } catch (IllegalStateException e) {
            row.getCell(cellNumber).setCellValue(0.0);
            cellNumericValue = Optional.ofNullable(row.getCell(cellNumber)).map(Cell::getNumericCellValue).orElse(0.0);
        }

        return cellNumericValue;
    }


    @Override
    public void sendToReport(String excelFileREF, FileTypes type,StatementDto statementDto) throws IOException {
        File inputExcelFile = new File(excelFileREF);
        FileInputStream fileInputStream = new FileInputStream(inputExcelFile);
        Workbook workbook;
        Sheet workbookSheet;
        switch (type) {
            case XLS: {
                workbook = new HSSFWorkbook(fileInputStream);
                workbookSheet = workbook.getSheet(statementDto.getSheetName());
                break;
            }
            case XLSX: {
                workbook = new XSSFWorkbook(fileInputStream);
                workbookSheet = workbook.getSheet(statementDto.getSheetName());
                break;
            }
            default:
                throw new InvalidTypeException("Unknown file type: " + type);
        }

        Optional<Sheet> optionalSheet = Optional.ofNullable(workbookSheet);
        Map<String, ArrayList<Double>> states = statementDto.getStates();
        Map<String, ArrayList<Double>> mismatchedStates = new HashMap<>();

        for (String budgetClassificationCode : states.keySet()) {
            boolean isMatched = false;

            for (Row row : optionalSheet.orElseThrow(SheetDoesNotExistException::new)) {
                // TODO refactor row.getCell(0)==null to Optional? How?
                if (row.getCell(0) == null) {
                    continue;
                }

                if (budgetClassificationCode.equals(row.getCell(0) + "")) {
                    for (int i = 1; i <= 7; i++) {
                        Optional<Cell> optionalCell = Optional.ofNullable(row.getCell(i));
                        optionalCell.orElse(row.createCell(i, CellType.NUMERIC)).setCellValue(states.get(budgetClassificationCode).get(i - 1));
                    }

                    isMatched = true;
                    break;
                }
            }
            if (! isMatched) {
                mismatchedStates.put(budgetClassificationCode, states.get(budgetClassificationCode));
            }
        }

        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(excelFileREF);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();

        String mismatchedFileREF = "C:\\Users\\17274003\\Documents\\misMatched.xlsx";
        FileOutputStream mismatchedFileOutputStream = new FileOutputStream(mismatchedFileREF);
        Workbook mismatchedWorkbook = new XSSFWorkbook();
        Sheet mismatchedSheet = mismatchedWorkbook.createSheet();

        int x = 0;
        for (String mismatchedBCC : mismatchedStates.keySet()) {

            Row row = mismatchedSheet.createRow(x);
            row.createCell(0).setCellValue(mismatchedBCC);

            for (int j = 1; j <= 7; j++) {
                row.createCell(j).setCellValue(mismatchedStates.get(mismatchedBCC).get(j-1));
            }
            x++;
        }

        mismatchedSheet.autoSizeColumn(0);

        mismatchedWorkbook.write(mismatchedFileOutputStream);
        mismatchedWorkbook.close();
        mismatchedFileOutputStream.close();

    }
}
