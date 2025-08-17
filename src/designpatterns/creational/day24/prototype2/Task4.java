package designpatterns.creational.day24.prototype2;

// Prototype Design Pattern – Plant Objects Cloning

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

