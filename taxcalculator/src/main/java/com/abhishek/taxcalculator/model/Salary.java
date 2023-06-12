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
}
