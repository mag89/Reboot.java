package ru.tax.statementToReport.converter;

import ru.tax.statementToReport.dto.StatementDto;

import java.io.IOException;

public interface Converter {

    StatementDto convertToStatementDto(String excelFileREF, FileTypes type, int sheetNum) throws IOException;

    void sendToReport(String excelFileREF, FileTypes type, StatementDto statementDto) throws IOException;
}
