package com.abhishek.taxcalculator;

import com.abhishek.taxcalculator.model.Salary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
public class SalaryControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getSalaryTemplateShouldReturnEmptySalaryObject() {
        ResponseEntity<Salary> response = restTemplate.getForEntity("/salary/get-template", Salary.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
