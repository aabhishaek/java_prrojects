package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.model.Tax;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {

    private Tax tax;

    public TaxServiceImpl(Tax tax) {
        this.tax = tax;
    }

    @Override
    public void chooseRegime(Regime regime) {
        tax.setRegime(regime);
    }
}
