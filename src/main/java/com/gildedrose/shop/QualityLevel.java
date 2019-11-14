package com.gildedrose.shop;

public enum QualityLevel {

    REGULAR(0,50),
    LEGENDARY(0,80);

    private int min;
    private int max;

    QualityLevel(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
