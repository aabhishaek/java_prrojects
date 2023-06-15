package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.model.Salary;
import com.abhishek.taxcalculator.service.SalaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }
    @PostMapping
    public ResponseEntity<Void> storeSalary(@RequestBody Salary salary) {
        salaryService.storeSalary(salary);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Salary> getSalary(@PathVariable String userId) {
        Salary salary = salaryService.getSalary(userId);
        return ResponseEntity.ok().body(salary);
    }

}
