package designpatterns.structural.day25.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class ShapeFactory {
    private static final Map<String, Shapes> circleMap = new HashMap<>();

    public static Shapes getCircle(String color) {
        Shapes circle = circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
        }

        return circle;
    }
}
