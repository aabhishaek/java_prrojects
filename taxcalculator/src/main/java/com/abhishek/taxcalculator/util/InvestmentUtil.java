package com.abhishek.taxcalculator.util;

import com.abhishek.taxcalculator.enums.InvestmentOption;
import com.abhishek.taxcalculator.enums.SectionName;
import com.abhishek.taxcalculator.model.Section;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InvestmentUtil {

    public Section constructSection(Section section, SectionName sectionName) {
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
