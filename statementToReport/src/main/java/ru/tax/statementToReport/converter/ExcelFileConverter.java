package ru.tax.statementToReport.converter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

                ArrayList<Boolean> isNonZeroCell = new ArrayList<>(5);
                for (int i = 3; i <= 7; i++) {
                    Cell cell = Optional.ofNullable(row.getCell(i)).orElse(row.createCell(i));

                    if ((cell + "").equals("")) {
                        cell.setCellValue(0.0);
                    }

                    double doubleCellValue = Double.parseDouble(row.getCell(i) + "");
                    isNonZeroCell.add(doubleCellValue != 0.0);
                }

                if ((isNonZeroCell.get(0)) || (isNonZeroCell.get(1)) || (isNonZeroCell.get(2))
                        || (isNonZeroCell.get(3)) || (isNonZeroCell.get(4))) {
                    charge = new ArrayList<>();
                    for (int i = 1; i <= 7; i++) {
                        charge.add(Double.parseDouble(row.getCell(i) + ""));
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
                        optionalCell.orElse(row.createCell(i)).setCellValue(states.get(budgetClassificationCode).get(i - 1));
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

        String mismatchedFileREF = "./misMatched.xlsx";
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
