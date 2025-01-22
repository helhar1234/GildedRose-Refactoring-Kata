package com.gildedrose.itemUpdaters;

import com.gildedrose.model.Item;

public class BackstagePassUpdater extends ItemUpdater {
    public BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            increaseQuality();
            if (item.sellIn < 10) {
                increaseQuality();
            }
            if (item.sellIn < 5) {
                increaseQuality();
            }
        }
    }
}
