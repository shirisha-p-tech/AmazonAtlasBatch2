package exceptionhandling;
import java.util.ArrayList;
public class DS_Task010 {

        public static void main(String args[]){
            ArrayList<String> al = new ArrayList<>();
            al.add("Perapagu");
            al.add("Shirisha");
            System.out.println("Original List : "+al);

            al.add(1, "Hello");
            System.out.println("After Adding element at index 1 : "+ al);

            al.remove(0);
            System.out.println("Element removed from index 0 : "+ al);

            al.remove("Hello");
            System.out.println("Element Hello removed : "+ al);

            al.set(0, "Hi");
            System.out.println("List after updation of value : "+al);
        }

}
