package javabasics;
class Customer{
    void accept()
    {
        System.out.println("Customer's accept method called");
    }
    void display()
    {
        System.out.println("Customer's display method called");
    }

}
public class Task008 {
    public static void main(String[] args) {
        Customer cs_obj=new Customer();
        cs_obj.accept();
        cs_obj.display();
    }
}
