package com.gildedrose.itemUpdaters;

import com.gildedrose.model.Item;

public class AgedBrieUpdater extends ItemUpdater {
    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();
        if (item.sellIn < 0) {
            increaseQuality();
        }
    }
}
