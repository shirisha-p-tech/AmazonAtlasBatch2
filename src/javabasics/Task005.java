package javabasics;
public class Task005 {
    static int add(int a,int b){
        return a+b;
    }
    static int subtract(int a,int b){
        return a-b;
    }
    static int multiply(int a,int b){
        return a*b;
    }
    static int division(int a,int b){
        return a/b;
    }

    public static void main(String[] args) {
        System.out.println("Addition:"+add(10,5));
        System.out.println("Subtraction:"+ subtract(10,5));
        System.out.println("Multiplication:"+ multiply(10,5));
        System.out.println("Division:"+ division(10,5));
    }
}
