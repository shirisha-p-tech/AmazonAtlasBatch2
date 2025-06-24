//Renaming file using main arguments
package iofilehandling;
import java.io.*;
public class IO_Task008{

    public static void main(String args[])
        {
            File f1 = new File(args[0]);
            File f2 = new File(args[1]);
            f1.renameTo(f2);
            System.out.println("Rename File " +f1+" To "+f2+" Sucessfully ");
        }
    }


