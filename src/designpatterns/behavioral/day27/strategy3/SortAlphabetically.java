package designpatterns.behavioral.day27.strategy3;


import java.util.Collections;
import java.util.List;

// Concrete Strategy

public class SortAlphabetically implements StrategySortInterface {
    @Override
    public void sort(List<String> items){
        Collections.sort(items, String.CASE_INSENSITIVE_ORDER);
    }
}
