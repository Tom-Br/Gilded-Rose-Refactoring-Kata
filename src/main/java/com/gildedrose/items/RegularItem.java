package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.shop.QualityCheck;
import com.gildedrose.shop.QualityDegradation;
import com.gildedrose.shop.ShopItem;

public class RegularItem extends Item implements ShopItem, QualityCheck {

    public RegularItem(String name, int sellIn, int quality) {
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
            QualityDegradation degradation = QualityDegradation.REGULAR;
            this.quality -= degradation.getAmount();
        }
        else{
            QualityDegradation degradation = QualityDegradation.REGULAR_OVER_TIME;
            this.quality -= (degradation.getAmount());
        }

    }

    @Override
    public int getQuality() {
        return quality;
    }

}
