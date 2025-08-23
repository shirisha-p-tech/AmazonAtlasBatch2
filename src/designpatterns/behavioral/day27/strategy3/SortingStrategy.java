package designpatterns.behavioral.day27.strategy3;

import java.util.ArrayList;
import java.util.List;

// Context class

public class SortingStrategy {
    private StrategySortInterface st;
    private List<String> list;


    public SortingStrategy(StrategySortInterface st){
        this.st = st;
        this.list = new ArrayList<>();
    }

    public void setStrategyForSorting(StrategySortInterface st){
        this.st = st;
    }

    public void addItem(String item){
        list.add(item);
    }

    public void performSort(){
        if(st!=null){
            st.sort(list);
        }
    }

    public List<String> getList(){
        return new ArrayList<>(list);
    }

}
