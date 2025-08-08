package ooad.day24;

// Prototype Method Design Pattern – Plant Objects Cloning

// Prototype interface
interface Plant extends Cloneable {
    void grow();
    String getGrowthType();
    void setGrowthType(String type);
    Plant clone();
}

// Concrete class: Creeper
class Creeper implements Plant {
    private String growthType;

    @Override
    public void grow() {
        System.out.println("Creeper is growing on the ground or walls");
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

// Concrete class: Shrub
class Shrub implements Plant {
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

// Test the prototype pattern
public class Task4 {
    public static void main(String[] args) {
        // Original Creeper
        Creeper creeper1 = new Creeper();
        creeper1.setGrowthType("Horizontal");
        creeper1.grow();
        System.out.println("Creeper1 Growth Type: " + creeper1.getGrowthType());

        // Clone Creeper
        Creeper creeper2 = (Creeper) creeper1.clone();
        creeper2.setGrowthType("Wall climbing");
        creeper2.grow();
        System.out.println("Creeper2 Growth Type: " + creeper2.getGrowthType());

        // Original Shrub
        Shrub shrub1 = new Shrub();
        shrub1.setGrowthType("Vertical");
        shrub1.grow();
        System.out.println("Shrub1 Growth Type: " + shrub1.getGrowthType());

        // Clone Shrub
        Shrub shrub2 = (Shrub) shrub1.clone();
        shrub2.setGrowthType("Compact vertical");
        shrub2.grow();
        System.out.println("Shrub2 Growth Type: " + shrub2.getGrowthType());
    }
}

