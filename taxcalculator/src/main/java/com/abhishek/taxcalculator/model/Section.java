package com.abhishek.taxcalculator.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Section {

    private com.abhishek.taxcalculator.enums.Section sectionName;
    private Map<String, BigDecimal> investments;
    private BigDecimal totalInvestments;
    private BigDecimal totalExemptions;

    private BigDecimal totalDeductions;
}
