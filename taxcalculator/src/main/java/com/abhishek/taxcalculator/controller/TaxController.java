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

    /**
     * Endpoint to choose the Tax Regime based on which tax will be calculated
     *
     * @param "Accepts" regime param as enum (OLD_REGIME, NEW REGIME)
     * @return Returns text response indicating regime has been successfully set
     */
    @PostMapping(value = "/choose-regime", consumes = "application/json", produces = "application/json")
    public ResponseEntity<APIResponse> chooseRegime(@RequestBody Regime regime) {
        taxService.chooseRegime(regime);
        return wrapResponse(null, "tax.regime.chosen.message", 200);
    }

    /**
     *  Endpoint to GET the chosen regime
      * @return Chosen regime
     */
    @GetMapping(value = "/regime", produces = "application/json")
    public ResponseEntity<APIResponse> getRegime() {
        return wrapResponse(taxService.getRegime());
    }
}