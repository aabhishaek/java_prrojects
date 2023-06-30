package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.common.APIResponse;
import com.abhishek.taxcalculator.model.Investment;
import com.abhishek.taxcalculator.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    private InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }
    @GetMapping
    public ResponseEntity<APIResponse> getInvestments() {

        Investment investment = investmentService.getInvestments();
        APIResponse response = new APIResponse();
        response.setData(investment);
        return ResponseEntity.ok().body(response);
    }
}
