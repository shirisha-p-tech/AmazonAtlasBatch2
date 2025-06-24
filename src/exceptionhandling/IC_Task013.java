package exceptionhandling;
class OuterClass2 {
    int x = 10;
    static class InnerClass2 {
        int y = 5;
    }
}

public class IC_Task013 {
    public static void main(String[] args) {
        //OuterClass2 myOuter = new OuterClass2();
        OuterClass2.InnerClass2 myInner = new OuterClass2.InnerClass2();
        System.out.println(myInner.y);
    }
}

