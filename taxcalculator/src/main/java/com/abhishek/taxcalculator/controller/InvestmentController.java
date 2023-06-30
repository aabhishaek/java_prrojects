package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.common.APIResponse;
import com.abhishek.taxcalculator.model.Investment;
import com.abhishek.taxcalculator.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    private InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    /**
     * Method to get details on Tax saving Investments in detail
     *
     * @return Investment detail containing granular detail of each section
     */
    @GetMapping
    public ResponseEntity<APIResponse> getInvestments() {

        Investment investment = investmentService.getInvestments();
        APIResponse response = new APIResponse();
        response.setData(investment);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/declare")
    public ResponseEntity<APIResponse> declareInvestments(@RequestBody Investment investment) {
        investmentService.declareInvestments(investment);

        APIResponse response = new APIResponse();
        response.setMessage("Investment declared successfully");

        return ResponseEntity.ok().body(response);
    }
}
