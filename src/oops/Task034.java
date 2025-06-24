package oops;
//Polymorphism - method overloading
public class Task034{
    void add(int x, int y){
        System.out.println(x+ " &&& "+ y);
    }
    void add(int x, int y, int z ){
        System.out.println(x + " $$$ "+ y+ " $$$"+ z);
    }
    public static void main(String[] args){
        Task034 tobj = new Task034();
        tobj.add(10,20);
        tobj.add(100,200,300);
    }
}
