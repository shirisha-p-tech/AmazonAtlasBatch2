package javabasics;
public class Task029 {

        public static void main(String args[])
        {
            int intArray[] = { 1, 2, 3 };

            int cloneArray[] = intArray.clone();

            System.out.println("Original Array");
            for (int i = 0; i < intArray.length; i++) {
                System.out.print(intArray[i] + " ");
            }
            System.out.println("");
            System.out.println("CloneArray");
            for (int i = 0; i < cloneArray.length; i++) {
                System.out.print(cloneArray[i] + " ");
            }
            // will print false as shallow copy is created
            System.out.println("");
            System.out.print("Is Cloned Array address equals Original Array address : ");
            System.out.println(intArray == cloneArray);


            cloneArray[0]=100;
            System.out.println("After changing cloned array value at 0 index:Original Array");
            for(int i : intArray)
                System.out.print(i + " ");
            System.out.println("");
            System.out.println("After changing cloned array value at 0 index:Cloned Array");
            for(int i : cloneArray)
                System.out.print(i+ " ");
        }


}
