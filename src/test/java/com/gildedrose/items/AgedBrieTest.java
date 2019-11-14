package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    @Test
    public void testAgedBrieIncreasinInQuality(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.getShopItems()[0].name);
        assertEquals(1, app.getShopItems()[0].sellIn);
        assertEquals(1, app.getShopItems()[0].quality);
    }

    @Test
    public void testAgedBrieNeverPassing50(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals("Aged Brie", app.getShopItems()[0].name);
        assertEquals(0, app.getShopItems()[0].sellIn);
        assertEquals(50, app.getShopItems()[0].quality);
    }

}
