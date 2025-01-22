package com.gildedrose.itemUpdaters;

import com.gildedrose.model.Item;

public class NormalItemUpdater extends ItemUpdater {
    public NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality();
        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }
}
