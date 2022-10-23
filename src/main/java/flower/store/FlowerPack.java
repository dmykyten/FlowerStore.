package flower.store;

import lombok.Getter;
import lombok.Setter;

public class FlowerPack {
    @Getter @Setter
    private Flower flower = null;
    @Getter @Setter
    private int quantity = 0;

    double getPrice(){
        if(flower != null)
            return quantity * flower.getPrice();
        return 0;
    }
}
