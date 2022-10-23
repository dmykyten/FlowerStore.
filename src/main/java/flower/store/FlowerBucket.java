package main.java.flower.store;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FlowerBucket {
    @Getter @Setter
    private List<FlowerPack<? extends Flower>> flowerPacks = null;
    private double price = 0;

    public double getPrice(){
        if(price == 0) {
            for (FlowerPack<? extends Flower> f : flowerPacks) {
                price += f.getPrice();
            }
        }
        return price;
    }
}
