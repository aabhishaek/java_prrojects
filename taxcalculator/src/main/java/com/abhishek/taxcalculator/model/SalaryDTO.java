package com.abhishek.taxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalaryDTO {

    private String id;
    private String field;
    private String label;
    private Object value;
}
