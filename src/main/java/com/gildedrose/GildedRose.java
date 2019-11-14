package com.gildedrose;

import com.gildedrose.shop.ShopItem;

import java.util.List;

public class GildedRose {

    private List<ShopItem> shopItems;

    public GildedRose(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public void updateQuality() {
        shopItems.forEach(ShopItem::updateItem);
    }

}