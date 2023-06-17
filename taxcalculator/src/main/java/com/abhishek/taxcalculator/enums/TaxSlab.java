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
    SLAB_1_OLD(250000 , 0, 0,OLD_REGIME),
    SLAB_2_OLD(500000, 5, 12500,OLD_REGIME),
    SLAB_3_OLD(1000000, 20, 100000,OLD_REGIME),
    SLAB_4_OLD(0,30, 0, OLD_REGIME),

    // New Regime
    SLAB_1_NEW(300000, 0, 0, NEW_REGIME),
    SLAB_2_NEW(600000, 5, 15000, NEW_REGIME),
    SLAB_3_NEW(900000, 10, 30000, NEW_REGIME),
    SLAB_4_NEW(1200000, 15, 45000, NEW_REGIME),
    SLAB_5_NEW(1500000, 20, 60000, NEW_REGIME),
    SLAB_6_NEW(0, 30, 0, NEW_REGIME);

    private int upperLimit;
    private int percentageOfTax;
    private int maxTax;
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