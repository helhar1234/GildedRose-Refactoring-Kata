package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NormalItemTest {

    @Test
    void testNormalItemQualityDecreasesByOne() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, items[0].quality, "Quality should decrease by 1");
        assertEquals(9, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNormalItemQualityDecreasesByOneNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(20, items[0].quality, "Quality should not remain the same after update");
        assertNotEquals(10, items[0].sellIn, "SellIn should not remain the same after update");
    }

    @Test
    void testNormalItemQualityDecreasesByTwoAfterSellIn() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(18, items[0].quality, "Quality should decrease by 2 after sellIn is 0");
        assertEquals(-1, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNormalItemQualityDecreasesByTwoAfterSellInNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(20, items[0].quality, "Quality should not remain the same when sellIn is 0");
        assertNotEquals(0, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testNormalItemQualityDoesNotGoBelowZero() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality, "Quality should not go below 0");
        assertEquals(9, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNormalItemQualityDoesNotGoBelowZeroNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(-1, items[0].quality, "Quality should not go below 0");
        assertNotEquals(10, items[0].sellIn, "SellIn should not remain unchanged");
    }

    @Test
    void testNormalItemQualityDecreasesByTwoWithZeroSellInAndOneQuality() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality, "Quality should not go below 0, even with double decrease");
        assertEquals(-1, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testNormalItemQualityDecreasesByTwoWithZeroSellInAndOneQualityNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(1, items[0].quality, "Quality should not remain unchanged");
        assertNotEquals(0, items[0].sellIn, "SellIn should not remain the same");
    }
}
