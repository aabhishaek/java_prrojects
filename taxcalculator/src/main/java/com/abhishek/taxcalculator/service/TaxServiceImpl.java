package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.model.Salary;
import com.abhishek.taxcalculator.model.Tax;
import com.abhishek.taxcalculator.util.TaxCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxServiceImpl implements TaxService {

    private final Tax tax;
    private final SalaryService salaryService;

    public TaxServiceImpl(Tax tax, SalaryService salaryService) {
        this.tax = tax;
        this.salaryService = salaryService;
    }

    @Override
    public void chooseRegime(Regime regime) {
        tax.setRegime(regime);
    }

    @Override
    public Regime getRegime() {
        return tax.getRegime();
    }

    @Override
    public BigDecimal calculateTotalTaxableIncome(String userId) {
        Salary salary = salaryService.getSalary(userId);

        TaxCalculator calculator = new TaxCalculator();
        return calculator.calculateTotalTaxableIncomeFromSalary(salary);
    }
}
