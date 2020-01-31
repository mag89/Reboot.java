package ru.tax.statementToReport.exceptions;

public class SheetDoesNotExistException extends RuntimeException {
    public SheetDoesNotExistException() {
    }

    public SheetDoesNotExistException(String message) {
        super(message);
    }
}
