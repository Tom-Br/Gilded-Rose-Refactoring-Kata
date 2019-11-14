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

    private void updateItem(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

            if (item.quality > 0) {

                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }

            }

        } else {

            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                    if (item.sellIn < 11) {

                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }

                    }

                    if (item.sellIn < 6) {

                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }

                    }

                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}