package iofilehandling;
public class ReverseString {

    public static void main(String[] args) {
        String orig ="hello hi";
        StringBuilder sb= new StringBuilder(orig);
        System.out.println("Original String:"+ orig);
        System.out.println("Reversed String:"+ sb.reverse());

    }
}
