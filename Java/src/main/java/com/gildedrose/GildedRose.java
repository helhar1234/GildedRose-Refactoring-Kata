package com.gildedrose;

import com.gildedrose.itemUpdaters.*;
import com.gildedrose.model.Item;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            getItemUpdater(item).update();
        }
    }

    private ItemUpdater getItemUpdater(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdater(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassUpdater(item);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdater(item);
            default:
                return new NormalItemUpdater(item);
        }
    }
}
