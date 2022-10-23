package flower.store;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Flower {
    @Getter
    private double sepalLength = 0;
    private FlowerColor color = null;
    @Getter
    private double price = 0;
    @Getter
    private FlowerType flowerType = null;

    public String getColor() {
        return color.toString();
    }
    public void setColor(FlowerColor color){
        if(this.color == null){
            this.color = color;
        }
    }
}
