package com.abhishek.taxcalculator.model;

import com.abhishek.taxcalculator.enums.SalaryType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Map;

@Data
@EqualsAndHashCode
public class Salary {

    private String userId;
    private String userName;
    private SalaryType salaryType;
    private String month;
    private BigDecimal basic;
    private BigDecimal hra;
    private BigDecimal specialAllowance;
    private Map<String, BigDecimal> otherAllowances;
}
