package com.gildedrose.shop;

public enum QualityDegradation {

    REGULAR(1);

    private int amount;

    QualityDegradation(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
