package com.abhishek.taxcalculator.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Regime {

    OLD_REGIME("old_regime"),
    NEW_REGIME("new_regime");

    private String regime;

    Regime(String regime) {
        this.regime = regime;
    }

    public String getRegime() {
        return regime;
    }

    @JsonCreator
    public static Regime getRegimeFromString(String regime) {
        for (Regime reg : Regime.values()) {
            if (regime.toLowerCase().equals(reg.getRegime())) {
                return reg;
            }
        }
        return null;
    }
}
