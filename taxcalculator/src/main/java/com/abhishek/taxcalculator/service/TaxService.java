package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.Regime;

import java.math.BigDecimal;

public interface TaxService {

    public void chooseRegime(Regime regime);
    public Regime getRegime();
    public BigDecimal calculateTotalTaxableIncome(String userId);
}
