//Factorial of a number using recursion
package datastructures.day14;
import java.util.Scanner;

public class Task012 {
    // Recursive factorial method
    public static int factorial(int n){
        if (n==1||n==0)
            return 1;
        else
            return n * factorial(n-1); // Recursive call
    }

    public static void main(String[] args) {
        // Taking number from user
        System.out.println("Enter any number to check its factorial:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println("Factorial of "+n+" is "+factorial(n));

    }
}
