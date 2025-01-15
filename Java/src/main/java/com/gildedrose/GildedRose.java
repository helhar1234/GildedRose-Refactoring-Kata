package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                updateAgedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePasses(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                // Sulfuras does not need any updates
            } else {
                updateNormalItem(item);
            }
        }
    }

    private void updateNormalItem(Item item) {
        decreaseSellIn(item);

        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        decreaseSellIn(item);

        if (item.quality < 50) {
            increaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality < 50) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        decreaseSellIn(item);

        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 10 && item.quality < 50) {
                increaseQuality(item);
            }

            if (item.sellIn < 5 && item.quality < 50) {
                increaseQuality(item);
            }
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }
}
