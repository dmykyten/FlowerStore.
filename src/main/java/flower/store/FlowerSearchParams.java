package flower.store;

import lombok.Getter;
import lombok.Setter;


class FlowerSearchParams{
    @Getter @Setter
    private FlowerColor color = null;
    @Getter @Setter
    private FlowerType flowerType = null;
    @Getter @Setter
    private double minPrice = 0;
    @Getter @Setter
    private double maxPrice = Double.MAX_VALUE;
    @Getter @Setter
    private double minSepalLength = 0;
    @Getter @Setter
    private double maxSepalLength = Double.MAX_VALUE;
}
