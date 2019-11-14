package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.shop.ShopItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    @Test
    public void testAgedBrieIncreasinInQuality(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new AgedBrieItem("Aged Brie", 2, 0));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item agedBrieItem = app.getShopItems().get(0).getItem();
        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(1, agedBrieItem.sellIn);
        assertEquals(1, agedBrieItem.quality);
    }

    @Test
    public void testAgedBrieNeverPassing50(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new AgedBrieItem("Aged Brie", 2, 49) );
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item agedBrieItem = app.getShopItems().get(0).getItem();
        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(0, agedBrieItem.sellIn);
        assertEquals(50, agedBrieItem.quality);
    }

}
