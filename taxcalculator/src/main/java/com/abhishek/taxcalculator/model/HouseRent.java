package com.abhishek.taxcalculator.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HouseRent {

    private String month;
    private BigDecimal rent;
    private boolean isMetro;

}
