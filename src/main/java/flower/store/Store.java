package flower.store;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Store {
    @Setter
    List<FlowerBucket> flowerBuckets = null;

    private boolean compare(Flower flower, FlowerSearchParams params) {
        if(flower.getColor() != null) {
            if (!flower.getColor().equals(params.getColor().toString()))
                return false;
        }

        if(flower.getFlowerType() != null) {
            if (flower.getFlowerType() != params.getFlowerType())
                return false;
        }

        if (flower.getPrice() > params.getMaxPrice())
            return false;

        if (params.getMinPrice() > flower.getPrice())
            return false;

        if (flower.getSepalLength() > params.getMaxSepalLength())
            return false;

        return params.getMinSepalLength() <= flower.getSepalLength();
    }

    public List<FlowerPack> search(FlowerSearchParams params) {
        List<FlowerPack> packs = new ArrayList<>();

        for (FlowerBucket bucket : flowerBuckets) {
            for (FlowerPack pack : bucket.getFlowerPacks()) {
                Flower flower = pack.getFlower();
                if (pack.getQuantity() != 0 && compare(flower, params)) {
                    packs.add(pack);
                }
            }
        }
        return packs;
    }
}
