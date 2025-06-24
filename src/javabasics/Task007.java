package javabasics;
import java.util.Scanner;
public class Task007 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ID: ");
        String id = sc.nextLine();
        System.out.println("Enter Password: ");
        String pwd = sc.nextLine();
        System.out.println("Your Id id: "+id);
        System.out.print("Your password is: ");
        for(int i=0;i<pwd.length();i++){
            System.out.print("*");
        }

        sc.close();
    }
}
