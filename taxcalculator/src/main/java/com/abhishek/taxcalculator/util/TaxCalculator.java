package com.abhishek.taxcalculator.util;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.enums.TaxSlabs;
import com.abhishek.taxcalculator.model.Salary;

import java.math.BigDecimal;
import java.util.List;

public class TaxCalculator {

    public BigDecimal getTotalTaxableIncomeFromSalary(Salary salary) {
        BigDecimal totalTaxableIncome = BigDecimal.ZERO;

        BigDecimal totalSalary = salary.getTotal();
        List<TaxSlabs> slabs = TaxSlabs.getSlabsForGivenRegime(Regime.OLD_REGIME);

        for (TaxSlabs slab: 
             ) {

        }

    }
}
