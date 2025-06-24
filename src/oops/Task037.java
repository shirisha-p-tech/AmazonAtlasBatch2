package oops;
class Employee{
    private String pwd="1615";
    protected double salary=60000;
    public int empID= 12345;

}
class Hr extends Employee{
    void display(){
    //System.out.println(pwd); // error pwd has private access in Employee
    System.out.println(salary);
    System.out.println(empID);
    }
}
public class Task037{
    public static void main(String[] args){
    Hr h = new Hr();
    h.display();
    }
    
}