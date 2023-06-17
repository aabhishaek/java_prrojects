package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.model.Salary;
import com.abhishek.taxcalculator.model.Tax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class TaxServiceTest {

    private TaxService taxService;
    private SalaryService salaryService;

    @BeforeEach
    public void setUp() {
        this.salaryService = new SalaryServiceImpl(new HashMap<>());
        this.taxService = new TaxServiceImpl(new Tax(), salaryService);
    }

    @Test
    public void shouldStoreRegime() {
        taxService.chooseRegime(Regime.OLD_REGIME);

        Assertions.assertEquals(Regime.OLD_REGIME, taxService.getRegime());
    }

    @Test
    public void shouldCalculateTaxableIncomeForGivenSalary() {
        Salary salary = Salary.builder().userId("user_1")
                .userName("Basic Person")
                .basic(new BigDecimal(431364))
                .hra(new BigDecimal(215676))
                .specialAllowance(new BigDecimal(343560))
                .otherAllowances(new HashMap<>() {{
                    put("children_education_allowance", new BigDecimal(2400));
                    put("telephone_reimbursements", new BigDecimal(24000));
                    put("Education_allowance", new BigDecimal(35004));
                    put("data_reimbursements", new BigDecimal(9000));
                    put("festival_allowance", new BigDecimal(2000));
                    put("food_allowance", new BigDecimal(26400));
                    put("other_allowances", new BigDecimal(3000));
                }})
                .employerEPFContribution(new BigDecimal(21600))
                .professionalTax(new BigDecimal(2500))
                .deductions(new HashMap<>(){{
                    put("food_deduction", new BigDecimal(26400));
                }})
                .build();

        salaryService.storeSalary(salary);
        BigDecimal totalTaxableIncome = taxService.calculateTotalTaxableIncome(salary.getUserId());

        Assertions.assertEquals(new BigDecimal(110880), totalTaxableIncome);

    }


}
