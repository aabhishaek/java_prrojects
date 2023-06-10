package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.model.Salary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @GetMapping("/get-template")
    public ResponseEntity<Salary> getSalaryTemplate() {
        return ResponseEntity.ok().body(new Salary());
    }
}
