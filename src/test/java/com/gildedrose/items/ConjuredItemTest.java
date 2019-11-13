package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredItemTest {

    @Test
    public void testConjuredManaCakeDegradingTwiceAsFast(){
        Item[] items = new Item[] {  new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.getItems()[0].name);
        assertEquals(2, app.getItems()[0].sellIn);
        assertEquals(4, app.getItems()[0].quality);
    }

    @Test
    public void testConjuredManaCakeDegrading4xAfterSellinDate(){
        Item[] items = new Item[] {  new Item("Conjured Mana Cake", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.getItems()[0].name);
        assertEquals(-1, app.getItems()[0].sellIn);
        assertEquals(-4, app.getItems()[0].quality);
    }

}
