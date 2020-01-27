package ru.tax.statementToReport.dto;

import java.util.ArrayList;
import java.util.Map;

public class StatementDto {
    private String sheetName;
    private Map<String, ArrayList<Double>> states;

    public StatementDto(Map<String, ArrayList<Double>> states, String sheetName) {
        this.sheetName = sheetName;
        this.states = states;
    }

    public Map<String, ArrayList<Double>> getStates() {
        return states;
    }

    public String getSheetName() {
        return sheetName;
    }
}
