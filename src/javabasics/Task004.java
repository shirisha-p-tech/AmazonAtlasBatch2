package javabasics;
public class Task004 {
    public static void main(String[] args) {
        int a=2;
        int b=5;
        int temp;
        System.out.println("Before swap a is "+a+" and b is "+b);
        temp=a;
        a=b;
        b=temp;
        System.out.println("After  swap a is "+a+" and b is "+b);
    }
}
