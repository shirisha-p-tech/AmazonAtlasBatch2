package designpatterns.creational.day26.singleton2;

import java.sql.SQLOutput;
import java.util.List;

// Driver class
public class Task16 {
    public static void main(String[] args) {

        try {
            DManager dm = DManager.getInstance();

            dm.addItem(10);
            dm.addItem(20);
            dm.addItem(30);
            dm.removeItem(1);

            List<Integer> finalList = dm.getList();

            System.out.println("Final List: "+ finalList);

        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }



    }

}
