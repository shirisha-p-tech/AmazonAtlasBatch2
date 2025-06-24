package javabasics;
public class Task010 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        int num3 = 8;
        int greatest;

        if (num1 >= num2 && num1 >= num3) {
            greatest = num1;
        }
        else if (num2 >= num3) {
            greatest = num2;
        }
        else {
            greatest = num3;
        }

        System.out.println("The largest number is: " + greatest);
    }
}

