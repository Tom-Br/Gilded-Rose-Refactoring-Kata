package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.shop.ShopItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConjuredItemTest {

    @Test
    public void testConjuredManaCakeDegradingTwiceAsFast(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new ConjuredItem("Conjured Mana Cake", 3, 6) );
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item conjured = app.getShopItems().get(0).getItem();
        assertEquals("Conjured Mana Cake", conjured.name);
        assertEquals(2, conjured.sellIn);
        assertEquals(4, conjured.quality);
    }

    @Test
    public void testConjuredManaCakeDegrading4xAfterSellinDate(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new ConjuredItem("Conjured Mana Cake", 0, 8) );
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item conjured = app.getShopItems().get(0).getItem();
        assertEquals("Conjured Mana Cake", conjured.name);
        assertEquals(-1, conjured.sellIn);
        assertEquals(4, conjured.quality);
    }

}
