package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpecialItemTest {

    @Test
    void testAgedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(41, items[0].quality, "Quality of Aged Brie should increase by 1");
        assertEquals(9, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testAgedBrieIncreasesInQualityNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(40, items[0].quality, "Quality of Aged Brie should not remain the same");
        assertNotEquals(10, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testAgedBrieQualityDoesNotExceedFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, items[0].quality, "Quality of Aged Brie should not exceed 50");
        assertEquals(9, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testAgedBrieQualityDoesNotExceedFiftyNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(51, items[0].quality, "Quality of Aged Brie should not exceed 50");
        assertNotEquals(10, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testBackstagePassesIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, items[0].quality, "Quality of Backstage Passes should increase by 1 when sellIn > 10");
        assertEquals(14, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testBackstagePassesIncreaseInQualityNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(20, items[0].quality, "Quality of Backstage Passes should not remain the same when sellIn > 10");
        assertNotEquals(15, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testBackstagePassesIncreaseByTwoWhenSellInTenOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, items[0].quality, "Quality of Backstage Passes should increase by 2 when sellIn <= 10");
        assertEquals(9, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testBackstagePassesIncreaseByTwoWhenSellInTenOrLessNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(20, items[0].quality, "Quality of Backstage Passes should not remain the same when sellIn <= 10");
        assertNotEquals(10, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testBackstagePassesIncreaseByThreeWhenSellInFiveOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, items[0].quality, "Quality of Backstage Passes should increase by 3 when sellIn <= 5");
        assertEquals(4, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testBackstagePassesIncreaseByThreeWhenSellInFiveOrLessNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(20, items[0].quality, "Quality of Backstage Passes should not remain the same when sellIn <= 5");
        assertNotEquals(5, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testBackstagePassesDropToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality, "Quality of Backstage Passes should drop to 0 after concert");
        assertEquals(-1, items[0].sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testBackstagePassesDropToZeroAfterConcertNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(20, items[0].quality, "Quality of Backstage Passes should not remain the same when concert is over");
        assertNotEquals(0, items[0].sellIn, "SellIn should not remain the same");
    }

    @Test
    void testSulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, items[0].quality, "Quality of Sulfuras should remain unchanged");
        assertEquals(10, items[0].sellIn, "SellIn of Sulfuras should remain unchanged");
    }

    @Test
    void testSulfurasNeverChangesNegative() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertNotEquals(79, items[0].quality, "Quality of Sulfuras should not decrease");
        assertNotEquals(9, items[0].sellIn, "SellIn of Sulfuras should not decrease");
    }
}
