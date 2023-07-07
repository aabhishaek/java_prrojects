package com.abhishek.taxcalculator.service;

import com.abhishek.taxcalculator.enums.SectionName;
import com.abhishek.taxcalculator.model.Investment;
import com.abhishek.taxcalculator.model.Section;
import com.abhishek.taxcalculator.util.InvestmentUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private Investment investment;

    @Override
    public Investment getInvestments() {

        investment = Optional.ofNullable(investment).orElseGet(() -> new Investment());

        InvestmentUtil investmentUtil = new InvestmentUtil();
        for (SectionName sectionName : SectionName.values()) {

            Section section = investmentUtil.constructSection(investment.getSection(sectionName), sectionName);
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

}
