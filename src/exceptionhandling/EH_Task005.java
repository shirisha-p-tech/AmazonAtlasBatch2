package exceptionhandling;

public class EH_Task005 {
    public static void main(String args[]) {
        try {
            int a[] = new int[2];
            int b = 0;   // change 0 to 10 and check..
            int c = 1/b;
            System.out.println("Access element three :" + a[3]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException thrown  :" + e);
        }catch (Exception e) {
            System.out.println("Exception thrown  :" + e.getMessage());
        }
        System.out.println("Out of the block");
    }

}
