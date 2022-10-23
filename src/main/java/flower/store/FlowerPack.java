package main.java.flower.store;

import lombok.Getter;
import lombok.Setter;

public class FlowerPack<T extends Flower> {
    @Getter @Setter
    private T flower = null;
    @Getter @Setter
    private int quantity = 0;

    double getPrice(){
        return quantity * flower.getPrice();
    }
}
