package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.common.APIResponse;
import com.abhishek.taxcalculator.model.Investment;
import com.abhishek.taxcalculator.service.InvestmentService;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investments")
public class InvestmentController extends BaseController {

    private InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService, ResourceBundleMessageSource source) {
        super(source);
        this.investmentService = investmentService;
    }

    /**
     * GET Endpoint which responds with tax saving investments made under each section
     *
     * @return Investment detail containing granular detail of each section
     */
    @GetMapping
    public ResponseEntity<APIResponse> getInvestments() {

        Investment investment = investmentService.getInvestments();
        return wrapResponse(investment);
    }

    /**
     * POST Endpoint to declare the invesments made under each section
     *
     * @param investment
     * @return declared investments
     */
    @PostMapping("/declare")
    public ResponseEntity<APIResponse> declareInvestments(@RequestBody Investment investment) {
        investmentService.declareInvestments(investment);

        return wrapResponse("investment.declare.successful.message");
    }
}
