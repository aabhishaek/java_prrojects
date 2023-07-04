package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.InvestmentOption;
import com.abhishek.taxcalculator.enums.SectionName;
import com.abhishek.taxcalculator.model.Investment;
import com.abhishek.taxcalculator.model.Section;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private Investment investment;

    @Override
    public Investment getInvestments() {

        investment = Optional.ofNullable(investment).orElseGet(() -> new Investment());

        for (SectionName sectionName : SectionName.values()) {

            Section section = constructSection(investment.getSection(sectionName), sectionName);
            investment.setSection(section);

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

    private Section constructSection(Section section, SectionName sectionName) {
        section = Optional.ofNullable(section).orElse(new Section());

        if (section.getSectionName() == null) {
            section.setSectionName(sectionName);
        }

        Map<String, BigDecimal> investmentMapForSection = Optional.ofNullable(section.getInvestments())
                .orElseGet(() -> new HashMap<>());

        List<InvestmentOption> investmentOptionsForSection = InvestmentOption.getOptionsForSection(sectionName);

        for (InvestmentOption option : investmentOptionsForSection) {
            investmentMapForSection.putIfAbsent(option.toString(), BigDecimal.ZERO);
        }

        section.setInvestments(investmentMapForSection);
        return section;
    }

}
