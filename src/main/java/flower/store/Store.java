package main.java.flower.store;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Store {
    @Setter
    List<FlowerBucket> flowerBuckets = null;

    private boolean compare(Flower flower, FlowerSearchParams params) {
        if (!flower.getColor().equals(params.getColor()))
            return false;

        if (flower.getFlowerType() != params.getFlowerType())
            return false;

        if (flower.getPrice() > params.getMaxPrice())
            return false;

        if (params.getMinPrice() > flower.getPrice())
            return false;

        if (flower.getSepalLength() > params.getMaxSepalLength())
            return false;

        return params.getMinSepalLength() <= flower.getSepalLength();
    }

    public List<FlowerPack<? extends Flower>> search(FlowerSearchParams params) {
        List<FlowerPack<? extends Flower>> packs = new ArrayList<>();

        for (FlowerBucket bucket : flowerBuckets) {
            for (FlowerPack<? extends Flower> pack : bucket.getFlowerPacks()) {
                Flower flower = pack.getFlower();
                if (pack.getQuantity() != 0 && compare(flower, params)) {
                    packs.add(pack);
                }

            }
        }
        return packs;
    }
}
