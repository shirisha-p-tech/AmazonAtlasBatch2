
class OuterClass1 {
    int x = 10;
    private class InnerClass1 {
        int y = 5;
    }
}

public class IC_Task012 {
    public static void main(String[] args) {
        OuterClass1 myOuter = new OuterClass1();
      //  OuterClass1.InnerClass1 myInner = myOuter.new InnerClass1(); //Private inner class so error
     //   System.out.println(myInner.y + myOuter.x);
    }
}



