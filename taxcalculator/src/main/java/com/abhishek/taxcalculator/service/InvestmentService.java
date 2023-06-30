package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.model.Investment;

public interface InvestmentService {

    public Investment getInvestments();
    public void declareInvestments(Investment investment);
}
