package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.model.Salary;

public interface SalaryService {

    public void storeSalary(Salary salary);
    public Salary getSalary(String userId);
}
