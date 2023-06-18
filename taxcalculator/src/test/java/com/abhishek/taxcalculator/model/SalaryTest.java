package com.abhishek.taxcalculator.model;

import com.abhishek.taxcalculator.util.SalaryCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class SalaryTest {

    @Test
    public void shouldReturnTotalSalaryWhenGivenSalarySplit() {
        Salary inputSalary = Salary.builder()
                .userId("user_1")
                .userName("user_One")
                .basic(new BigDecimal(100000))
                .hra(new BigDecimal(50000))
                .specialAllowance(new BigDecimal(20000))
                .otherAllowances(new HashMap<>() {{
                    put("leave_travel_allowance", new BigDecimal(90000));
                    put("food_allowance", new BigDecimal(26400));
                }})
                .build();

        Assertions.assertEquals(new BigDecimal(286400), SalaryCalculator.getTotalSalary(inputSalary));
    }
}
