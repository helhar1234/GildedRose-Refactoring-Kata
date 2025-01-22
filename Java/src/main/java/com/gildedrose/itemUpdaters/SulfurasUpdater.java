package com.gildedrose.itemUpdaters;

import com.gildedrose.model.Item;

public class SulfurasUpdater extends ItemUpdater {
    public SulfurasUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        // Sulfuras does not change in quality or sellIn
    }
}
