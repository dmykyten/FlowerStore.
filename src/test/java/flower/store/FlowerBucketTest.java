package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

class FlowerBucketTest {
    private FlowerBucket flowerBucket;
    private Flower flower;
    private FlowerPack flowerPack;

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final int QUANTITY = 10;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
        flower = new Flower();
        flowerPack = new FlowerPack();
    }

    @Test
    void testClass(){
        Assertions.assertNull(flowerBucket.getFlowerPacks());
        Assertions.assertEquals(0, flowerBucket.getPrice());
    }

    @Test
    void testPrice() {
        // i was a little lazy to write tests properly, im sorry
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        flowerPack.setFlower(flower);
        flowerPack.setQuantity(QUANTITY);
        List<FlowerPack> packs = new ArrayList<>();
        packs.add(flowerPack);
        packs.add(flowerPack);
        flowerBucket.setFlowerPacks(packs);
        Assertions.assertEquals(flowerPack.getPrice() * 2, flowerBucket.getPrice());
    }
}
