package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.model.Tax;
import com.abhishek.taxcalculator.service.TaxServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxControllerTest {

    private TaxController taxController;

    @BeforeEach
    public void setUp() {
        this.taxController = new TaxController(new TaxServiceImpl(new Tax()));
    }

    @Test
    public void shouldStoreCorrectRegime() {
        taxController.chooseRegime(Regime.OLD_REGIME);

        Assertions.assertEquals(Regime.OLD_REGIME, taxController.getRegime().getBody());
    }
}
