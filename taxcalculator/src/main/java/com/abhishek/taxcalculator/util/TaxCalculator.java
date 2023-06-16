package com.abhishek.taxcalculator.util;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.enums.TaxSlab;
import com.abhishek.taxcalculator.model.Salary;

import java.math.BigDecimal;
import java.util.List;

public class TaxCalculator {

    private static FINAL final BigDecimal STANDARD_DEDUCTION = new BigDecimal(50000);

    /**
     * Calculates the total taxable income based on the given salary
     * (Taxable income is by default calculated for old_slab)
     *
     * @param salary
     * @return BigDecimal - Total Taxable Income
     */
    public BigDecimal calculateTotalTaxableIncomeFromSalary(Salary salary) {
        BigDecimal totalTaxableIncome = BigDecimal.ZERO;

        BigDecimal totalSalary = salary.getTotal();
        BigDecimal totalDeductions = salary.getDeductions();

        List<TaxSlab> slabs = TaxSlab.getSlabsForGivenRegime(Regime.OLD_REGIME);

        // Subtract Standard deductions
        totalSalary = totalSalary.subtract(totalDeductions);
        totalSalary = totalSalary.subtract(STANDARD_DEDUCTION);

        for (TaxSlab slab : slabs) {
            if (totalSalary.compareTo(BigDecimal.ZERO) <= 0) {
                break;
            }

            BigDecimal payableTaxForSlab = BigDecimal.ZERO;
            if (slab.getPercentageOfTax() > 0) {
                if (new BigDecimal(slab.getMaxSalaryRange()).compareTo(totalSalary) >= 0) {
                    payableTaxForSlab = totalSalary.multiply(new BigDecimal(slab.getPercentageOfTax() / 100));
                } else {

                    if (slab.getMaxSalaryRange() == Integer.MAX_VALUE) {
                        payableTaxForSlab = totalSalary.multiply(new BigDecimal(slab.getPercentageOfTax() / 100));
                    } else {
                        payableTaxForSlab = new BigDecimal(slab.getMaxSalaryRange())
                                .multiply(new BigDecimal(slab.getPercentageOfTax() / 100));
                    }
                }
                totalTaxableIncome = totalTaxableIncome.add(payableTaxForSlab);
            }
            totalSalary = totalSalary.subtract(new BigDecimal(slab.getMaxSalaryRange()));
        }

        return totalTaxableIncome;

    }
}
