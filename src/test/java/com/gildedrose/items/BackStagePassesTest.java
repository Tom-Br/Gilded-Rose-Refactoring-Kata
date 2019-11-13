package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackStagePassesTest {

    @Test
    public void testBackStagePassesOver10DaysIncrementBy1(){
        Item[] items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[0].name);
        assertEquals(14, app.getItems()[0].sellIn);
        assertEquals(21, app.getItems()[0].quality);
    }

    @Test
    public void testBackStagePassesBetween10And5DaysIncrementBy2(){
        Item[] items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 9, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[0].name);
        assertEquals(8, app.getItems()[0].sellIn);
        assertEquals(47, app.getItems()[0].quality);
    }

    @Test
    public void testBackStagePassesUnder5DaysIncrementBy3(){
        Item[] items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 5, 33) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[0].name);
        assertEquals(4, app.getItems()[0].sellIn);
        assertEquals(36, app.getItems()[0].quality);
    }

    @Test
    public void testBackStagePassesAfterConcert(){
        Item[] items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 0, 34) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[0].name);
        assertEquals(-1, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
    }

    @Test
    public void testBackStagePassesNeverGoOver50Quality(){
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.getItems()[0].quality);
        assertEquals(50, app.getItems()[1].quality);
        assertEquals(50, app.getItems()[2].quality);
    }

}
