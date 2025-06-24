package oops;
//Java won't support Multiple Inheritance
class Clock{
    public void clock_method() {
        System.out.println("This is Clock class method");
    }
}
//public class Task032 extends Calculation, Clock { //Error multiple inheritance is not supported
    public class Task032 extends Calculation {
    public static void main(String[] args) {
        int a = 20, b = 10;
        Task032 demo = new Task032();
        demo.addition(a, b);
        demo.Subtraction(a, b);
        //demo.clock_method();
        
    }
}
