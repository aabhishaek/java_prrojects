package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.model.Tax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxServiceTest {

    private TaxService taxService;

    @BeforeEach
    public void setUp() {
        this.taxService = new TaxServiceImpl(new Tax());
    }

    @Test
    public void shouldStoreRegime() {
        taxService.chooseRegime(Regime.OLD_REGIME);

        Assertions.assertEquals(Regime.OLD_REGIME, taxService.getRegime());
    }


}
