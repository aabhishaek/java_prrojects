package com.abhishek.taxcalculator.util;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.enums.TaxSlab;
import com.abhishek.taxcalculator.model.Salary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TaxUtil {

    private Regime chosenRegime;
    public TaxUtil(Regime regime) {
        this.chosenRegime = regime;
    }

    private static final BigDecimal STANDARD_DEDUCTION = new BigDecimal(50000);

    private BigDecimal calculateTaxableIncomeFromSalary(Salary salary) {
        return SalaryCalculator.getTotalSalary(salary)
                .subtract(SalaryCalculator.getDeductions(salary))
                .subtract(STANDARD_DEDUCTION);
    }

    public BigDecimal calculateTotalTaxApplicableForGivenSalary(Salary salary) {
        final BigDecimal taxableIncomeFromSalary = calculateTaxableIncomeFromSalary(salary);
        final List<TaxSlab> applicableSlabs = TaxSlab.getSlabsForGivenRegime(chosenRegime);

        BigDecimal totalTaxApplicable = BigDecimal.ZERO;

        BigDecimal tempSalaryTotal = new BigDecimal(taxableIncomeFromSalary.toString());

        for (int i = 0; i < applicableSlabs.size(); i++) {
            TaxSlab slab = applicableSlabs.get(i);

            if (tempSalaryTotal.compareTo(BigDecimal.ZERO) <= 0) {
                break;
            }

            BigDecimal upperLimitOfSlab = slab.getUpperLimit();
            BigDecimal taxPercentForSlab = slab.getPercentageOfTax()
                    .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);

            if (upperLimitOfSlab != null && taxableIncomeFromSalary.compareTo(upperLimitOfSlab) > 0) {
                    totalTaxApplicable = totalTaxApplicable.add(slab.getMaxTax());
            } else {
                BigDecimal payableTax = tempSalaryTotal.multiply(taxPercentForSlab);
                totalTaxApplicable = totalTaxApplicable.add(payableTax);
            }

            BigDecimal previousSlabUpperLimit = i > 0
                    ? applicableSlabs.get(i - 1).getUpperLimit()
                    : BigDecimal.ZERO;

            tempSalaryTotal = tempSalaryTotal.subtract(slab.getUpperLimit().subtract(previousSlabUpperLimit));

        }

        return new BigDecimal(totalTaxApplicable.intValue());
    }
}
