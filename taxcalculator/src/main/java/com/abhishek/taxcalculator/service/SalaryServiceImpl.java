package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.model.Salary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SalaryServiceImpl implements SalaryService {

    private Map<String, Salary> salaryMap;

    public SalaryServiceImpl(Map<String, Salary> salaryMap) {
        this.salaryMap = salaryMap;
    }

    @Override
    public void storeSalary(Salary salary) {
        if (Objects.isNull(salaryMap)) {
            salaryMap = new HashMap<>();
        }

        salaryMap.put(salary.getUserId(), salary);
    }

    @Override
    public Salary getSalary(String userId) {
        return salaryMap.getOrDefault(userId, new Salary());
    }


}
