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
    private Map<String, BigDecimal> otherAllowances;

    public BigDecimal getTotal() {
        BigDecimal totalSalary = BigDecimal.ZERO;

        BigDecimal otherAllowancesTotal = BigDecimal.ZERO;
        for (String allowance : otherAllowances.keySet()) {
            otherAllowancesTotal = otherAllowancesTotal.add(otherAllowances.get(allowance));
        }

        totalSalary = totalSalary.add(basic);
        totalSalary = totalSalary.add(hra);
        totalSalary = totalSalary.add(specialAllowance);
        totalSalary = totalSalary.add(otherAllowancesTotal);

        return totalSalary;
    }
}
