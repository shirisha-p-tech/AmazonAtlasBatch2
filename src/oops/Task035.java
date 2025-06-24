package oops;
//Polymorphism - Type of parameters
public class Task035{
    void add(char x, char y){
       System.out.println(x+ " &&& "+ y);
        
    }
    void add(int x, int y, int z ){
        System.out.println(x + " $$$ "+ y+ " $$$"+ z);
    }
    public static void main(String[] args){
        Task035 tobj = new Task035();
        tobj.add('d','a');
        tobj.add(100,200,300);
    }
}
