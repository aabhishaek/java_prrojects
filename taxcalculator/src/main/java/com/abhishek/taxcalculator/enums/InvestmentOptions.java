package com.abhishek.taxcalculator.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvestmentOptions {

    ELSS_FUNDS("ELSS Funds", "", Section.SECTION_80_C),
    NPS_SCHEME("NPS SCHEME", "", Section.SECTION_80_C),
    ULIP("Life Insurance", "", Section.SECTION_80_C),
    TAX_SAVING_FD("TAX SAVING FD", "", Section.SECTION_80_C),
    PPF("Public Provident Fund", "", Section.SECTION_80_C),
    SCSS("Senior Citizen Saving Scheme", "", Section.SECTION_80_C),
    NSC("National Savings Certificate", "", Section.SECTION_80_C),
    SSY("Sukanya Samriddhi Yojana", "", Section.SECTION_80_C);
    private String option;
    private String description;
    private Section section;
}
