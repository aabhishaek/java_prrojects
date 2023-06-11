package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.model.Salary;

import java.util.List;

public interface SalaryService {

    public void storeSalary(Salary salary);
    public List<Salary> getSalaries(String userId);
}
