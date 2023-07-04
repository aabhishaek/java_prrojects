package com.abhishek.taxcalculator.model;

import com.abhishek.taxcalculator.enums.SectionName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Investment {

    private Section section10;
    private Section section16;
    private Section section80c;
    private Section section80ccc;
    private Section section80ccd;
    private Section section80d;
    private Section section80e;
    private Section section80g;
    private Section section80tta;

    public Section getSection(SectionName sectionName) {
        return switch (sectionName) {
            case SECTION_10 -> getSection10();
            case SECTION_16 -> getSection16();
            case SECTION_80_C -> getSection80c();
            case SECTION_80_CCC -> getSection80ccc();
            case SECTION_80_CCD -> getSection80ccd();
            case SECTION_80_D -> getSection80d();
            case SECTION_80_E -> getSection80e();
            case SECTION_80_G -> getSection80g();
            case SECTION_80_TTA -> getSection80tta();
        };
    }
    public void setSection(Section section) {
        switch (section.getSectionName()) {
            case SECTION_10 -> setSection10(section);
            case SECTION_16 -> setSection16(section);
            case SECTION_80_C -> setSection80c(section);
            case SECTION_80_CCC -> setSection80ccc(section);
            case SECTION_80_CCD -> setSection80ccd(section);
            case SECTION_80_D -> setSection80d(section);
            case SECTION_80_E -> setSection80e(section);
            case SECTION_80_G -> setSection80g(section);
            case SECTION_80_TTA -> setSection80tta(section);
        };
    }
}
