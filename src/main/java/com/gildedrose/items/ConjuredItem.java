package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.shop.QualityCheck;
import com.gildedrose.shop.QualityDegradation;
import com.gildedrose.shop.QualityLevel;
import com.gildedrose.shop.ShopItem;

public class ConjuredItem extends Item implements ShopItem, QualityCheck {

    private final QualityLevel QUALITY_LEVEL = QualityLevel.REGULAR;

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public void updateItem() {
        updateSellin();
        if(atMinimumQuality()){
            return;
        }
        deprecateQuality();
    }

    private void updateSellin(){
        sellIn--;
    }

    private void deprecateQuality() {
        if(sellIn >= 0){
            QualityDegradation degradation = QualityDegradation.CONJURED;
            this.quality -= degradation.getAmount();
        }
        else{
            QualityDegradation degradation = QualityDegradation.CONJURED_OVER_TIME;
            this.quality -= (degradation.getAmount());
        }

    }

    @Override
    public int getQuality() {
        return quality;
    }
}
