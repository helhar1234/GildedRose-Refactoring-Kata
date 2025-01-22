package com.gildedrose.itemUpdaters;

import com.gildedrose.model.Item;

public abstract class ItemUpdater {
    protected Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public abstract void update();

    protected void decreaseSellIn() {
        item.sellIn--;
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
