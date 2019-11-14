package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.shop.ShopItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LegendaryTest {

    @Test
    public void testSulfurasNeverDegrading(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80) );
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item sulfuras = app.getShopItems().get(0).getItem();
        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras.name);
        assertEquals(-1, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
        app.updateQuality();
        assertEquals(-2, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
        app.updateQuality();
        assertEquals(-3, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
    }

}
