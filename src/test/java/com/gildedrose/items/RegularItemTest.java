package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularItemTest {

    @Test
    public void testElixer(){
        Item[] items = new Item[] {  new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.getShopItems()[0].name);
        assertEquals(4, app.getShopItems()[0].sellIn);
        assertEquals(6, app.getShopItems()[0].quality);
    }

    @Test
    public void testElixerDegradingTwiceAsFastAfterSellin(){
        Item[] items = new Item[] {  new Item("Elixir of the Mongoose", 0, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.getShopItems()[0].name);
        assertEquals(-1, app.getShopItems()[0].sellIn);
        assertEquals(5, app.getShopItems()[0].quality);
    }

    @Test
    public void testDexterityVest(){
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.getShopItems()[0].name);
        assertEquals(9, app.getShopItems()[0].sellIn);
        assertEquals(19, app.getShopItems()[0].quality);
    }

    @Test
    public void testDexterityVestDegradingTwiceAsFastAfterSellin(){
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.getShopItems()[0].name);
        assertEquals(-1, app.getShopItems()[0].sellIn);
        assertEquals(18, app.getShopItems()[0].quality);
    }

}
