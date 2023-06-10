package com.abhishek.taxcalculator.enums;

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
}
