package designpatterns.behavioral.day27.strategy3;

import java.util.Scanner;

// Home Task - Driver class - Strategy DP - Sorting Strategy Example
public class Task01 {
    public static void main(String[] args) {

        String inputString;

        SortingStrategy ss = new SortingStrategy(new SortAlphabetically());


        System.out.println("Enter input Strings:(Type DONE to finish)");
        Scanner sc = new Scanner(System.in);

        while (!(inputString = sc.nextLine()).equalsIgnoreCase("DONE")) {
            ss.addItem(inputString);
        }

        ss.performSort();
        System.out.println("\nAlphabetically sorting:");
        for(String item: ss.getList() ){
            System.out.println(item);
        }


        ss.setStrategyForSorting(new SortLengthwise());
        ss.performSort();
        System.out.println("\nLengthwise sorting (descending order):");
        for(String item: ss.getList() ){
            System.out.println(item);
        }


    }



}
