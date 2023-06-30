package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.InvestmentOptions;
import com.abhishek.taxcalculator.enums.Section;
import com.abhishek.taxcalculator.model.Investment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private Investment investment;

    @Override
    public Investment getInvestments() {

        if (Objects.isNull(investment)) {
            investment = new Investment();

            for (Section section: Section.values()) {
                Map<String, BigDecimal> investmentMapForSection = new HashMap<>();
                for (InvestmentOptions option : InvestmentOptions.values()) {
                    if (option.getSection() == section) {
                        investmentMapForSection.putIfAbsent(option.toString(), BigDecimal.ZERO);
                    }
                }
                com.abhishek.taxcalculator.model.Section sectionObj = new com.abhishek.taxcalculator.model.Section();
                if (section == Section.SECTION_80_C) {
                    sectionObj.setSectionName(section);
                    sectionObj.setInvestments(investmentMapForSection);
                    investment.setSection80c(sectionObj);
                }
            }
        }
        return investment;
    }

    @Override
    public void declareInvestments(Investment investment) {
        if (Objects.isNull(investment)) {
            return;
        }

        this.investment = investment;

    }
}
