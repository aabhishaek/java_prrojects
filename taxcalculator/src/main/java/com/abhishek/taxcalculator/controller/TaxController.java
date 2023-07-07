package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.common.APIResponse;
import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.service.TaxService;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController extends BaseController{

    private TaxService taxService;

    public TaxController(TaxService taxService, ResourceBundleMessageSource messageSource) {
        super(messageSource);
        this.taxService = taxService;
    }

    @PostMapping(value = "/choose-regime", consumes = "application/json", produces = "application/json")
    public ResponseEntity<APIResponse> chooseRegime(@RequestBody Regime regime) {
        taxService.chooseRegime(regime);
        return wrapResponse(null, "tax.regime.chosen.message", 200);
    }

    @GetMapping(value = "/regime", produces = "application/json")
    public ResponseEntity<APIResponse> getRegime() {

        APIResponse response = new APIResponse();
        response.setData(taxService.getRegime());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/investments", produces = "application/json")
    public ResponseEntity<APIResponse> getInvestments() {


        return ResponseEntity.ok().body(new APIResponse());
    }
}
