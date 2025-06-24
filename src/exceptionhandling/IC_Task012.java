package exceptionhandling;
class OuterClass1 {
    int x = 10;
    private class InnerClass1 {
        int y = 5;
    }
}

public class IC_Task012 {
    public static void main(String[] args) {
        OuterClass1 myOuter = new OuterClass1();
        /* Below code gives error as inner class is private and cant be accessed
        OuterClass1.InnerClass1 myInner = myOuter.new InnerClass1();
        System.out.println(myInner.y + myOuter.x);
       */
    }
}



