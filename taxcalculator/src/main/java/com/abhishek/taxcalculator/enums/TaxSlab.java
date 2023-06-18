package com.abhishek.taxcalculator.enums;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.abhishek.taxcalculator.enums.Regime.NEW_REGIME;
import static com.abhishek.taxcalculator.enums.Regime.OLD_REGIME;

@AllArgsConstructor
public enum TaxSlab {

    // OLD REGIME
    SLAB_1_OLD(250000, 0, 0, OLD_REGIME),
    SLAB_2_OLD(500000, 5, 12500, OLD_REGIME),
    SLAB_3_OLD(1000000, 20, 100000, OLD_REGIME),
    SLAB_4_OLD(null, 30, null, OLD_REGIME),

    // New Regime
    SLAB_1_NEW(300000, 0, 0, NEW_REGIME),
    SLAB_2_NEW(600000, 5, 15000, NEW_REGIME),
    SLAB_3_NEW(900000, 10, 30000, NEW_REGIME),
    SLAB_4_NEW(1200000, 15, 45000, NEW_REGIME),
    SLAB_5_NEW(1500000, 20, 60000, NEW_REGIME),
    SLAB_6_NEW(null, 30, null, NEW_REGIME);

    private Integer upperLimit;
    private Integer percentageOfTax;
    private Integer maxTax;
    private Regime regime;

    public static List<TaxSlab> getSlabsForGivenRegime(Regime regime) {
        return Stream.of(TaxSlab.values())
                .filter(slab -> slab.getRegime() == regime)
                .collect(Collectors.toList());
    }

    public BigDecimal getUpperLimit() {
        return upperLimit != null ? new BigDecimal(upperLimit) : null;
    }

    public BigDecimal getPercentageOfTax() {
        return new BigDecimal(percentageOfTax);
    }

    public BigDecimal getMaxTax() {
        return maxTax != null ? new BigDecimal(maxTax) : null;
    }

    public Regime getRegime() {
        return regime;
    }
}
