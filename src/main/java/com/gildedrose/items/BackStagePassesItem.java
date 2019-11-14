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
        updateSellin();
        if(sellIn <= 0){
            quality = QUALITY_LEVEL.getMin();
            return;
        }
        improve();
        if(quality > QUALITY_LEVEL.getMax()){
            quality = QUALITY_LEVEL.getMax();
        }
    }

    private void improve() {
        if(sellIn > 10){
            quality++;
        }
        else if(sellIn > 5){
            quality += 2;
        }
        else if(sellIn > 0){
            quality += 3;
        }
    }

    private void updateSellin(){
        sellIn--;
    }

    @Override
    public int getQuality() {
        return quality;
    }

}
