package com.abhishek.taxcalculator.util;

import com.abhishek.taxcalculator.model.Salary;

import java.math.BigDecimal;

public class SalaryCalculator {

    private static BigDecimal getOtherAllowancesTotal(Salary salary) {
        return salary.getOtherAllowances()
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal getOtherDeductionsTotal(Salary salary) {
        return salary.getDeductions()
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal getTotalSalary(Salary salary) {
        return salary.getBasic()
                .add(salary.getHra())
                .add(salary.getSpecialAllowance())
                .add(getOtherAllowancesTotal(salary));
    }

    public static BigDecimal getDeductions(Salary salary) {
        return salary.getEmployerEPFContribution()
                .add(salary.getProfessionalTax())
                .add(getOtherDeductionsTotal(salary));
    }
}
