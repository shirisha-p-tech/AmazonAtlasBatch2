package exceptionhandling;
class OuterClass4 {
    int x = 10;
    static class InnerClass4 {
        static int y = 5;
    }
}
public class IC_Task015 {
    public static void main(String[] args) {
        OuterClass4.InnerClass4 myInner = new OuterClass4.InnerClass4();
        System.out.println(myInner.y);

    }
}





