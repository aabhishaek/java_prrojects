package com.abhishek.taxcalculator.model;

import lombok.Data;

import java.util.Map;

@Data
public class Section {

    private String sectionId;
    private String sectionName;
    private Map<String, String> investments;
    private Long totalInvestments;
    private Long totalExemptions;

    private Long totalDeductions;
}
