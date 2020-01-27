package ru.tax.statementToReport.exceptions;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String s) {
        super(s);
    }
}
