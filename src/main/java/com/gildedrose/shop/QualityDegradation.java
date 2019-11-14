package com.gildedrose.shop;

public enum QualityDegradation {

    REGULAR(1),
    REGULAR_OVER_TIME(2),
    CONJURED(2),
    CONJURED_OVER_TIME(4);

    private int amount;

    QualityDegradation(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
