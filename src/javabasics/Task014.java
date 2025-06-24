package javabasics;
public class Task014 {
    public static void main(String[] args) {
        char[] arr= {'a','e','i','o','u'};
        System.out.println(arr); //prints character array arr
        System.out.println(arr[0]); //prints 1st element of character array arr
        String[] names={"John", "Tina", "Rahul", "Sam"};

        System.out.println(names[0]); //prints 1st element of String array names
        names[1]="Siri"; //Overrides 2nd element of names Tina and assigns Siri
        System.out.println(names[1]); //prints Siri
        System.out.println(names.length); //Print length of the array names

        //System.out.println(names[4]); //this will give error as 4 is out of index(0-3)

    }
}
