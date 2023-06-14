package com.abhishek.taxcalculator.model;

import com.abhishek.taxcalculator.enums.Regime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Tax {

    private String taxId;
    private Regime regime;
    private List<Section> sections;
    private HouseRent hra;
    private BigDecimal totalTaxApplicable;
    private BigDecimal cess;
    private BigDecimal monthlyTaxApplicable;

}
