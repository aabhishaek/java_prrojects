package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.enums.Regime;
import com.abhishek.taxcalculator.service.TaxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController {

    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("/choose-regime")
    public ResponseEntity<Void> chooseRegime(@RequestBody Regime regime) {
        taxService.chooseRegime(regime);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-regime")
    public ResponseEntity<Regime> getRegime() {
        return ResponseEntity.ok().body(taxService.getRegime());
    }

}
