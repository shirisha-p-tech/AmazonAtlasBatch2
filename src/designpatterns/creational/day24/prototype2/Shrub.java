package designpatterns.creational.day24.prototype2;

// Concrete class: Shrub
public class Shrub implements Plant {
    private String growthType;

    @Override
    public void grow() {
        System.out.println("Shrub is growing upright");
    }

    @Override
    public String getGrowthType() {
        return growthType;
    }

    @Override
    public void setGrowthType(String type) {
        this.growthType = type;
    }

    @Override
    public Plant clone() {
        try {
            return (Plant) super.clone(); // this works because Cloneable is implemented
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}
