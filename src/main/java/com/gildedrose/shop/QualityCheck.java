package com.gildedrose.shop;

public interface QualityCheck {

    QualityLevel QUALITY_LEVEL = QualityLevel.REGULAR;

    int getQuality();

    default boolean atMinimumQuality(){
        return getQuality() == QUALITY_LEVEL.getMin();
    }

    default boolean atMaximumQuality(){
        return getQuality() == QUALITY_LEVEL.getMax();
    }

}
