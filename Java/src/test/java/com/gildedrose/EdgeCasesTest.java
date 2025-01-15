package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCasesTest {

    @Test
    void testQualityDoesNotDropBelowZero() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality, "Quality should not drop below 0");
        assertEquals(4, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testQualityDoesNotDropBelowZeroNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(-1, items[0].quality, "Quality should not go below 0");
        assertNotEquals(5, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testQualityDoesNotExceedFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, items[0].quality, "Quality should not exceed 50");
        assertEquals(4, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testQualityDoesNotExceedFiftyNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(51, items[0].quality, "Quality should not exceed 50");
        assertNotEquals(5, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNegativeSellInForNormalItem() {
        Item[] items = new Item[] { new Item("Normal Item", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, items[0].quality, "Quality should decrease by 2 when sellIn < 0");
        assertEquals(-2, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNegativeSellInForNormalItemNegative() {
        Item[] items = new Item[] { new Item("Normal Item", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(10, items[0].quality, "Quality should not remain the same when sellIn < 0");
        assertNotEquals(-1, items[0].sellIn, "SellIn should not remain unchanged");
    }

    @Test
    void testNegativeSellInForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, items[0].quality, "Quality of Aged Brie should increase by 2 when sellIn < 0");
        assertEquals(-2, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNegativeSellInForAgedBrieNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(10, items[0].quality, "Quality should not remain the same for Aged Brie when sellIn < 0");
        assertNotEquals(-1, items[0].sellIn, "SellIn should not remain unchanged");
    }

    @Test
    void testNegativeSellInForBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality, "Quality of Backstage Passes should drop to 0 when sellIn < 0");
        assertEquals(-2, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNegativeSellInForBackstagePassesNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(10, items[0].quality, "Quality of Backstage Passes should not remain the same when sellIn < 0");
        assertNotEquals(-1, items[0].sellIn, "SellIn should not remain unchanged");
    }

    @Test
    void testNegativeSellInForSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, items[0].quality, "Quality of Sulfuras should remain unchanged when sellIn < 0");
        assertEquals(-1, items[0].sellIn, "SellIn of Sulfuras should remain unchanged");
    }

    @Test
    void testNegativeSellInForSulfurasNegative() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(79, items[0].quality, "Quality of Sulfuras should not decrease even when sellIn < 0");
        assertNotEquals(-2, items[0].sellIn, "SellIn of Sulfuras should not decrease");
    }
}
