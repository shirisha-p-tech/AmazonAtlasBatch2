package designpatterns.behavioral.day27.strategy3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Concrete Strategy

public class SortLengthwise implements StrategySortInterface {
    @Override
    public void sort(List<String> items){
        Collections.sort(items, Comparator.comparingInt(String::length).reversed());
    }
}
