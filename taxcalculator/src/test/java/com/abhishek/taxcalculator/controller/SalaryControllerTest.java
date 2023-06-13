package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.model.Salary;
import com.abhishek.taxcalculator.service.SalaryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashMap;

public class SalaryControllerTest {

    private SalaryController salaryController;

    @BeforeEach
    public void setUp() {
        this.salaryController = new SalaryController(new SalaryServiceImpl(new HashMap<>()));
    }

    @Test
    public void shouldReturnOkAfterStoringGivenSalary() {
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

        ResponseEntity<Void> responseEntity = salaryController.storeSalary(salary);

        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());
    }

    @Test
    public void shouldReturnSalaryForTheGivenUserId() {
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
        salaryController.storeSalary(salary);

        ResponseEntity responseEntity = salaryController.getSalary("user_1");
        Assertions.assertEquals(salary, responseEntity.getBody());
    }

}
