//Fibonacci series of a number using recursion
package datastructures.day14;

import java.util.Scanner;

public class Task013 {
    // Recursive method to find the nth Fibonacci number
    public static int fibonacci(int n){
        if(n<2)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        System.out.println("Enter how many numbers you want to see in fibonacci series");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println("Fibonacci series: ");
        for(int i=0;i<n;i++){
            System.out.print(fibonacci(i)+ " ");
        }
    }

}
