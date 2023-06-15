package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.model.Salary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class SalaryServiceTest {

    private SalaryService salaryService;

    @BeforeEach
    public void setUp() {
        this.salaryService = new SalaryServiceImpl(new HashMap<>());
    }

    @Test
    public void shouldStoreSalaryForGivenUserId() {
        Salary salary = Salary.builder()
                .userId("user_1")
                .userName("user_One")
                .basic(new BigDecimal(10000))
                .hra(new BigDecimal(1000))
                .specialAllowance(new BigDecimal(100))
                .otherAllowances(new HashMap<>() {{
                    put("leave_travel_allowance", new BigDecimal(90000));
                }})
                .build();

        salaryService.storeSalary(salary);
        Assertions.assertEquals(salary, salaryService.getSalary("user_1"));
    }

    @Test
    public void shouldReturnEmptyObjectWhenGivenBadUserId() {
        Salary salary = Salary.builder()
                .userId("user_1")
                .userName("user_One")
                .basic(new BigDecimal(10000))
                .hra(new BigDecimal(1000))
                .specialAllowance(new BigDecimal(100))
                .otherAllowances(new HashMap<>() {{
                    put("leave_travel_allowance", new BigDecimal(90000));
                }})
                .build();

        salaryService.storeSalary(salary);
        Assertions.assertEquals(new Salary(), salaryService.getSalary("user_2"));
    }

}
