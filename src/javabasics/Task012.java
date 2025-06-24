package javabasics;
import java.util.Scanner;
public class Task012 {
    public static void main(String[] args) {

        String id= "Shirisha";
        String pwd="12345";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ID: ");
        String inputID = sc.nextLine();
        System.out.println("Enter Password: ");
        String inputPWD = sc.nextLine();
        int count=0;
        
        while(inputID.equals(id) && inputPWD.equals(pwd))
        {
            System.out.println("You have entered "+ ++count + " times");
            System.out.println("Enter ID: and pwd ");
            inputID = sc.nextLine();
            inputPWD = sc.nextLine();

        }
        //Do-while : It will execute at least once even if ID and pwd is wrong.
         /*do{
         System.out.println("You have entered "+ ++count + " times");
            System.out.println("Enter ID: and pwd ");
            inputID = sc.nextLine();
            inputPWD = sc.nextLine();
         }while(inputID.equals(id) && inputPWD.equals(pwd));
        */
        
        System.out.println("Login failed");
        sc.close();

    }
}