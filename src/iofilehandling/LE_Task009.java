package iofilehandling;
import java.lang.FunctionalInterface;

public class LE_Task009 {
    @FunctionalInterface
    interface MyInterface{
        //abstract method
        double getPiValue();
    }

    public static void main(String[] args) {
      //  declare a refernce of MyInterface
        MyInterface ref;
        // lambda expression
        ref = () -> 3.1415;

        System.out.println("Usage of Lambda exression Pi value: "+ ref.getPiValue());


        }
    }

