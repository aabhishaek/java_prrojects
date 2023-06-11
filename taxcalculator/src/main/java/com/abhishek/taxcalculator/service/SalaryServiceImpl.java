package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.model.Salary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalaryServiceImpl implements SalaryService{

    private Map<String, List<Salary>> salaryMap = new HashMap<>();
    @Override
    public void storeSalary(Salary salary) {
        if (salaryMap.containsKey(salary.getUserId())) {
            salaryMap.get(salary.getUserId()).add(salary);
        } else {
            salaryMap.put(salary.getUserId(), List.of(salary));
        }
    }

    @Override
    public List<Salary> getSalaries(String userId) {
        return salaryMap.getOrDefault(userId, new ArrayList<Salary>());
    }
}
