package com.abhishek.taxcalculator.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum InvestmentOption {

    ELSS_FUNDS("ELSS Funds", "", SectionName.SECTION_80_C),
    NPS_SCHEME("NPS Scheme", "", SectionName.SECTION_80_C),
    ULIP("Life Insurance", "", SectionName.SECTION_80_C),
    TAX_SAVING_FD("Tax Saving Fixed Deposit", "", SectionName.SECTION_80_C),
    PPF("Public Provident Fund", "", SectionName.SECTION_80_C),
    SCSS("Senior Citizen Saving Scheme", "", SectionName.SECTION_80_C),
    NSC("National Savings Certificate", "", SectionName.SECTION_80_C),
    SSY("Sukanya Samriddhi Yojana", "", SectionName.SECTION_80_C);
    private String option;
    private String description;
    private SectionName section;

    public static List<InvestmentOption> getOptionsForSection(SectionName sectionName) {
        return Arrays.stream(InvestmentOption.values())
                .filter(option -> option.getSection() == sectionName)
                .collect(Collectors.toList());
    }
}
