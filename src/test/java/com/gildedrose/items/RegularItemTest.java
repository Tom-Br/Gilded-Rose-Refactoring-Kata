package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.shop.ShopItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegularItemTest {

    @Test
    public void testElixer(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new RegularItem("Elixir of the Mongoose", 5, 7));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item elixir = app.getShopItems().get(0).getItem();
        assertEquals("Elixir of the Mongoose", elixir.name);
        assertEquals(4, elixir.sellIn);
        assertEquals(6, elixir.quality);
    }

    @Test
    public void testElixerDegradingTwiceAsFastAfterSellin(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new RegularItem("Elixir of the Mongoose", 0, 7));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item elixir = app.getShopItems().get(0).getItem();
        assertEquals("Elixir of the Mongoose", elixir.name);
        assertEquals(-1, elixir.sellIn);
        assertEquals(5, elixir.quality);
    }

    @Test
    public void testDexterityVest(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new RegularItem("+5 Dexterity Vest", 10, 20));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item dexterityVest = app.getShopItems().get(0).getItem();
        assertEquals("+5 Dexterity Vest", dexterityVest.name);
        assertEquals(9, dexterityVest.sellIn);
        assertEquals(19, dexterityVest.quality);
    }

    @Test
    public void testDexterityVestDegradingTwiceAsFastAfterSellin(){
        List<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new RegularItem("+5 Dexterity Vest", 10, 20));
        GildedRose app = new GildedRose(shopItems);
        app.updateQuality();
        Item dexterityVest = app.getShopItems().get(0).getItem();
        assertEquals("+5 Dexterity Vest", dexterityVest.name);
        assertEquals(-1, dexterityVest.sellIn);
        assertEquals(18, dexterityVest.quality);
    }

}
