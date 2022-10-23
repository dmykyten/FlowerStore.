package flower.store;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FlowerBucket {
    @Getter @Setter
    private List<FlowerPack> flowerPacks = null;
    private double price = 0;

    public double getPrice(){
        if(flowerPacks != null) {
            for (FlowerPack f : flowerPacks) {
                price += f.getPrice();
            }
        }
        return price;
    }
}
