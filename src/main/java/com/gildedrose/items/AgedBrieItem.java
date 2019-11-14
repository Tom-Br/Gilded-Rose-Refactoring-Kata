package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.shop.QualityCheck;
import com.gildedrose.shop.QualityLevel;
import com.gildedrose.shop.ShopItem;

public class AgedBrieItem extends Item implements ShopItem, QualityCheck {

    private final QualityLevel QUALITY_LEVEL = QualityLevel.REGULAR;

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public AgedBrieItem getItem() {
        return this;
    }

    @Override
    public void updateItem() {

    }

    @Override
    public int getQuality() {
        return quality;
    }

}
