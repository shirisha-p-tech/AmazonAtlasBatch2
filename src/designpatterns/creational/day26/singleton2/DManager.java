package designpatterns.creational.day26.singleton2;

import java.util.ArrayList;
import java.util.List;
// Singleton example 2
public class DManager {
    private static DManager instance;
    private List<Integer> list;

    // private Constructor
    private DManager(){
        if(instance!=null){
            throw new IllegalStateException("instance already created");
        }
        list = new ArrayList<>();

    }

    // Returns Singleton instance
    public static synchronized DManager getInstance(){
        if(instance == null){
            instance = new DManager();
        }
        return instance;
    }


    // Adds item to list
    public synchronized void addItem(int item){
        list.add(item);
    }

    // Removes dds item from list
    public synchronized void removeItem(int index){
        list.remove(index);
    }

    // Get the copy of list
    public synchronized List getList(){
        return new ArrayList<>(list);
    }

}
