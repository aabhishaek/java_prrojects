package com.abhishek.taxcalculator.model;

import com.abhishek.taxcalculator.enums.SectionName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Section {

    private SectionName sectionName;
    private Map<String, BigDecimal> investments;
    private BigDecimal totalInvestments;
    private BigDecimal totalExemptions;

    private BigDecimal totalDeductions;
}
