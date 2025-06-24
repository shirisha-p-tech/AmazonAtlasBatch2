package javabasics;
public class Task013 {
    public static void main(String[] args) {

        for(int i=10;i>0;i--) {
            if(i==7||i==5)
            continue;       //skips iteration i=7 and i=5
            else
            System.out.println(i);
        }
    }
}
