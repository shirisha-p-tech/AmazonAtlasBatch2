package oops;
//Polymorphism - sequence of parameters
public class Task036{
    void add(int x, float y){
       System.out.println(x+ " &&& "+ y);
        
    }
    void add(float x, int y){
        System.out.println(x + " $$$ "+ y);
    }
    public static void main(String[] args){
        Task036 tobj = new Task036();
        tobj.add(10.50f, 60);
	    tobj.add(100, 80.80f);

    }
}
