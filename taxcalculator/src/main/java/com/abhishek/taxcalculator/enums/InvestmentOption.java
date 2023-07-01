package com.abhishek.taxcalculator.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum InvestmentOption {

    ELSS_FUNDS("ELSS Funds", "", Section.SECTION_80_C),
    NPS_SCHEME("NPS Scheme", "", Section.SECTION_80_C),
    ULIP("Life Insurance", "", Section.SECTION_80_C),
    TAX_SAVING_FD("Tax Saving Fixed Deposit", "", Section.SECTION_80_C),
    PPF("Public Provident Fund", "", Section.SECTION_80_C),
    SCSS("Senior Citizen Saving Scheme", "", Section.SECTION_80_C),
    NSC("National Savings Certificate", "", Section.SECTION_80_C),
    SSY("Sukanya Samriddhi Yojana", "", Section.SECTION_80_C);
    private String option;
    private String description;
    private Section section;

    public static List<InvestmentOption> getOptionsForSection(Section section) {
        return Arrays.stream(InvestmentOption.values())
                .filter(option -> option.getSection() == section)
                .collect(Collectors.toList());
    }
}
