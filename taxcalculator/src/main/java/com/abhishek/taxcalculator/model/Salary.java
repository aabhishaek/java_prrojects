package com.abhishek.taxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    private String userId;
    private String userName;
    private BigDecimal basic;
    private BigDecimal hra;
    private BigDecimal specialAllowance;
    private BigDecimal employerEPFContribution;
    private BigDecimal professionalTax;
    private Map<String, BigDecimal> otherAllowances;

    private Map<String, BigDecimal> deductions;

    public BigDecimal getTotal() {
        BigDecimal totalSalary = BigDecimal.ZERO;


        totalSalary = totalSalary.add(basic);
        totalSalary = totalSalary.add(hra);
        totalSalary = totalSalary.add(specialAllowance);

        for (String allowance : otherAllowances.keySet()) {
            totalSalary = totalSalary.add(otherAllowances.get(allowance));
        }

        return totalSalary;
    }

    public BigDecimal getDeductions() {
        BigDecimal totalDeductions = BigDecimal.ZERO;

        totalDeductions = totalDeductions.add(employerEPFContribution);
        totalDeductions = totalDeductions.add(professionalTax);

        for (String deduction : deductions.keySet()) {
            totalDeductions = totalDeductions.add(deductions.get(deduction));
        }

        return totalDeductions;
    }
}
