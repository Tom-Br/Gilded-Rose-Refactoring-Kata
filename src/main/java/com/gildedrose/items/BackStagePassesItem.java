package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.shop.QualityCheck;
import com.gildedrose.shop.QualityLevel;
import com.gildedrose.shop.ShopItem;

public class BackStagePassesItem extends Item implements ShopItem, QualityCheck {

    private final QualityLevel QUALITY_LEVEL = QualityLevel.REGULAR;

    public BackStagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public Item getItem() {
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
