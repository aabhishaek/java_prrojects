package com.abhishek.taxcalculator.util;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.enums.TaxSlab;
import com.abhishek.taxcalculator.model.Salary;

import java.math.BigDecimal;
import java.util.List;

public class TaxCalculator {

    private static final BigDecimal STANDARD_DEDUCTION = new BigDecimal(50000);

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

        // Subtract Standard deductions
        totalSalary = totalSalary.subtract(totalDeductions);
        final BigDecimal totalSalaryWithDeductions = totalSalary.subtract(STANDARD_DEDUCTION);

        List<TaxSlab> applicableSlabs = TaxSlab.getSlabsForGivenRegime(Regime.OLD_REGIME);

        BigDecimal tempSalaryTotal = new BigDecimal(totalSalaryWithDeductions.toString());

        for (int i = 0; i < applicableSlabs.size(); i++) {
            TaxSlab slab = applicableSlabs.get(i);
            if (tempSalaryTotal.compareTo(BigDecimal.ZERO) <= 0) {
                break;
            }

            if (slab.getUpperLimit() > 0) {
                if (totalSalaryWithDeductions.compareTo(new BigDecimal(slab.getUpperLimit())) > 0) {
                    totalTaxableIncome = totalTaxableIncome.add(new BigDecimal(slab.getMaxTax()));
                } else {
                    BigDecimal percent = new BigDecimal(slab.getPercentageOfTax()).divide(new BigDecimal(100));
                    BigDecimal payableTax = tempSalaryTotal.multiply(percent);
                    totalTaxableIncome = totalTaxableIncome.add(payableTax);
                }
            } else {
                BigDecimal percent = new BigDecimal(slab.getPercentageOfTax()).divide(new BigDecimal(100));
                BigDecimal payableTax = tempSalaryTotal.multiply(percent);
                totalTaxableIncome = totalTaxableIncome.add(payableTax);
            }

            BigDecimal previousSlabLimit = i > 0 ? new BigDecimal(applicableSlabs.get(i - 1).getUpperLimit()) : BigDecimal.ZERO;
            tempSalaryTotal = tempSalaryTotal.subtract(new BigDecimal(slab.getUpperLimit()).subtract(previousSlabLimit));

        }

        return new BigDecimal(totalTaxableIncome.intValue());
    }
}
