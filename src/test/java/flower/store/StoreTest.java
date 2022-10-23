package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
class StoreTest {
    private FlowerSearchParams params;
    private Store store;

    private FlowerBucket flowerBucket;
    private Flower flower;
    private FlowerPack flowerPack;

    @BeforeEach
    public void init() {
        store = new Store();

        flowerBucket = new FlowerBucket();
        flower = new Flower();
        flowerPack = new FlowerPack();

        params = new FlowerSearchParams();

        params.setColor(FlowerColor.RED);
        params.setMinPrice(5);
        params.setMaxPrice(10);
        params.setMinSepalLength(2);
        params.setMaxSepalLength(5);
        params.setFlowerType(null);
    }

    @Test
    void testSearch() {
        double price = 7;
        flower.setPrice(price);
        flower.setColor(FlowerColor.RED);
        flower.setSepalLength(3);
        flowerPack.setFlower(flower);
        flowerPack.setQuantity(1);
        List<FlowerPack> packs = new ArrayList<>();
        packs.add(flowerPack);
        packs.add(flowerPack);
        flowerBucket.setFlowerPacks(packs);
        List<FlowerBucket> buckets = new ArrayList<>();
        buckets.add(flowerBucket);
        buckets.add(flowerBucket);
        store.setFlowerBuckets(buckets);
        Assertions.assertEquals(4, store.search(params).size());
    }
}
