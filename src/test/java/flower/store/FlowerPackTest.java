package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

class FlowerPackTest {
    private FlowerPack flowerPack;
    private Flower flower;

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;

    @BeforeEach
    void init() {
        flowerPack = new FlowerPack();
        flower = new Flower();
    }

    @Test
    void testClass(){
        Assertions.assertEquals(0, flowerPack.getQuantity());
        Assertions.assertEquals(0, flowerPack.getPrice());
    }

    @Test
    void testQuantity() {
        int quantity = RANDOM_GENERATOR.nextInt();
        flowerPack.setQuantity(quantity);
        Assertions.assertEquals(quantity, flowerPack.getQuantity());
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        flowerPack.setFlower(flower);
        Assertions.assertEquals(flower.getPrice() * flowerPack.getQuantity(), flowerPack.getPrice());
    }
}
