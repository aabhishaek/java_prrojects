package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.InvestmentOption;
import com.abhishek.taxcalculator.enums.SectionName;
import com.abhishek.taxcalculator.model.Investment;
import com.abhishek.taxcalculator.model.Section;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InvestmentServiceTest {

    private InvestmentService investmentService;

    @BeforeEach
    public void setup() {
        this.investmentService = new InvestmentServiceImpl();
    }

    @Test
    public void shouldDefaultAllInvestmentsWithZeroValue_WhenNoInvestmentsDeclared() {
        Investment investment = new Investment();

        for (SectionName sectionName : SectionName.values()) {
            Section section = constructSection(investment.getSection(sectionName), sectionName);
            investment.setSection(section);
        }

        Assertions.assertEquals(investmentService.getInvestments(), investment);
    }

    @Test
    public void canStore80cInvestment() {
        Investment invest = new Investment();
        Section section = new Section();

        Map<String, BigDecimal> investmentMap = new HashMap<>();
        investmentMap.put(InvestmentOption.PPF.getOption(), new BigDecimal(40000));

        section.setInvestments(investmentMap);
        invest.setSection80c(section);

        investmentService.declareInvestments(invest);

        Investment investment = investmentService.getInvestments();
        Assertions.assertTrue(investment.getSection80c() != null, "80C section doesn't exist");
        Assertions.assertTrue(investment.getSection80c().getInvestments() != null, "80C investment is null");
        Assertions.assertTrue(investment.getSection80c().getInvestments().get(InvestmentOption.PPF.getOption()).compareTo(BigDecimal.ZERO) > 0, "80C PPF investment was not captured");
        Assertions.assertEquals(investment.getSection80c().getInvestments().get(InvestmentOption.PPF.getOption()), new BigDecimal(40000));
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
