package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.Regime;

public interface TaxService {

    public void chooseRegime(Regime regime);
    public Regime getRegime();
}
