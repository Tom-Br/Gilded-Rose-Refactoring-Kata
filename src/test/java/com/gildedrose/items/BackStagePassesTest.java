package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.shop.ShopItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BackStagePassesTest {

    @Test
    public void testBackStagePassesOver10DaysIncrementBy1() {
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item backStagePass = app.getShopItems().get(0).getItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backStagePass.name);
        assertEquals(14, backStagePass.sellIn);
        assertEquals(21, backStagePass.quality);
    }

    @Test
    public void testBackStagePassesBetween10And5DaysIncrementBy2() {
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 9, 45));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item backStagePass = app.getShopItems().get(0).getItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backStagePass.name);
        assertEquals(8, backStagePass.sellIn);
        assertEquals(47, backStagePass.quality);
    }

    @Test
    public void testBackStagePassesUnder5DaysIncrementBy3() {
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 33));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item backStagePass = app.getShopItems().get(0).getItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backStagePass.name);
        assertEquals(4, backStagePass.sellIn);
        assertEquals(36, backStagePass.quality);
    }

    @Test
    public void testBackStagePassesAfterConcert() {
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 34));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item backStagePass = app.getShopItems().get(0).getItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backStagePass.name);
        assertEquals(-1, backStagePass.sellIn);
        assertEquals(0, backStagePass.quality);
    }

    @Test
    public void testBackStagePassesNeverGoOver50Quality() {

        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 3, 49));
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 9, 49));
        shopItems.add(new BackStagePassesItem("Backstage passes to a TAFKAL80ETC concert", 15, 49));
        GildedRose app = new GildedRose(shopItems);

        app.updateQuality();
        Item backStagePass = app.getShopItems().get(0).getItem();
        assertEquals(50, backStagePass.quality);
        Item backStagePass1 = app.getShopItems().get(1).getItem();
        assertEquals(50, backStagePass1.quality);
        Item backStagePass2 = app.getShopItems().get(2).getItem();
        assertEquals(50, backStagePass2.quality);

        app.updateQuality();
        backStagePass = app.getShopItems().get(0).getItem();
        assertEquals(50, backStagePass.quality);
        backStagePass1 = app.getShopItems().get(1).getItem();
        assertEquals(50, backStagePass1.quality);
        backStagePass2 = app.getShopItems().get(2).getItem();
        assertEquals(50, backStagePass2.quality);
    }

}
