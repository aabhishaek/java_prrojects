package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.model.Tax;
import com.abhishek.taxcalculator.service.SalaryService;
import com.abhishek.taxcalculator.service.SalaryServiceImpl;
import com.abhishek.taxcalculator.service.TaxServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TaxControllerTest {

    private TaxController taxController;

    @BeforeEach
    public void setUp() {
        Tax tax = new Tax();
        SalaryService service = new SalaryServiceImpl(new HashMap<>());
        this.taxController = new TaxController(new TaxServiceImpl(tax, service), null);
    }

    @Test
    public void shouldStoreCorrectRegime() {
        taxController.chooseRegime(Regime.OLD_REGIME);

        Assertions.assertEquals(Regime.OLD_REGIME, taxController.getRegime().getBody());
    }
}
