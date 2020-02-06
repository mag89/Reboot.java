package ru.tax.statementToReport;

import ru.tax.statementToReport.converter.Converter;
import ru.tax.statementToReport.converter.ExcelFileConverter;
import ru.tax.statementToReport.converter.FileTypes;
import ru.tax.statementToReport.dto.StatementDto;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Converter converter = new ExcelFileConverter();

        StatementDto statementDto;
        String statementFileRef = "C:\\Users\\17274003\\Documents\\statement.xls";
        String reportFileRef = "C:\\Users\\17274003\\Documents\\report.xlsx";

        try {
            statementDto = converter.convertToStatementDto(statementFileRef, FileTypes.XLS,0);
            converter.sendToReport(reportFileRef, FileTypes.XLSX, statementDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
