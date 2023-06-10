package com.abhishek.taxcalculator.enums;

public enum SalaryType {
    MONTH("month"),
    QUARTER("quarter"),
    ANNUAL("annual");

    private String salaryType;

    SalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getSalaryType() {
        return salaryType;
    }
}
