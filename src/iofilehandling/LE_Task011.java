package iofilehandling;
import java.util.Scanner;
public class LE_Task011 {
        @FunctionalInterface
        interface MyInterface1{
            //abstract method
            String reverse(String n);
        }

        public static void main(String[] args) {
            //  declare a reference of MyInterface1
            MyInterface1 ref = (str) -> {
                String result = "";
                for (int i = str.length() - 1; i >= 0; i--) {
                    result += str.charAt(i);
                }
                return result;
            };
            System.out.println("Enter any string to reverse:");
            Scanner sc=new Scanner(System.in);
            String st= sc.nextLine();

            System.out.println("Reversed String using Lambda expression:");
            System.out.println(ref.reverse(st));

        }

}
