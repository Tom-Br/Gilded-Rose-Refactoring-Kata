package com.gildedrose;

import com.gildedrose.items.*;
import com.gildedrose.shop.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new RegularItem("+5 Dexterity Vest", 10, 20));
        shopItems.add(new AgedBrieItem("Aged Brie", 2, 0));
        shopItems.add(new RegularItem("Elixir of the Mongoose", 5, 7));
        shopItems.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        shopItems.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80));
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        shopItems.add(new ConjuredItem("Conjured Mana Cake", 3, 6));

        GildedRose app = new GildedRose(shopItems);

        int days = 2;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (ShopItem shopItem : shopItems) {
                System.out.println(shopItem.getItem());
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
