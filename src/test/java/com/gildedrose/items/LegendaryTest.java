package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegendaryTest {

    @Test
    public void testSulfurasNeverDegrading(){
        Item[] items = new Item[] {  new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.getItems()[0].name);
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(80, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(80, app.getItems()[0].quality);
    }

}
