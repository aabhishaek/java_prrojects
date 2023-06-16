package com.abhishek.taxcalculator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.abhishek.taxcalculator.enums.Regime.NEW_REGIME;
import static com.abhishek.taxcalculator.enums.Regime.OLD_REGIME;

@Getter
@AllArgsConstructor
public enum TaxSlab {

    // OLD REGIME
    SLAB_1_OLD(0, 250000 , 0, OLD_REGIME),
    SLAB_2_OLD(250000, 500000, 5, OLD_REGIME),
    SLAB_3_OLD(500000, 1000000, 20, OLD_REGIME),
    SLAB_4_OLD(1000000, Integer.MAX_VALUE,30, OLD_REGIME),

    // New Regime
    SLAB_1_NEW(0, 300000, 0, NEW_REGIME),
    SLAB_2_NEW(300000, 600000, 5, NEW_REGIME),
    SLAB_3_NEW(600000, 900000, 10, NEW_REGIME),
    SLAB_4_NEW(900000, 1200000, 15, NEW_REGIME),
    SLAB_5_NEW(1200000, 1500000, 20, NEW_REGIME),
    SLAB_6_NEW(1500000, Integer.MAX_VALUE, 30, NEW_REGIME);

    private int minSalaryRange;
    private int maxSalaryRange;
    private int percentageOfTax;
    private Regime regime;

    public static List<TaxSlab> getSlabsForGivenRegime(Regime regime) {
        List<TaxSlab> slabs = new ArrayList<>();

        for (TaxSlab slab : TaxSlab.values()) {
            if (slab.getRegime() == regime) {
                slabs.add(slab);
            }
        }

        return slabs;
    }
}
