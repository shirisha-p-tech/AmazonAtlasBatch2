package ooad.day20;
// SRP Implementation
import java.io.FileWriter;
import java.io.IOException;

class Customer {
    String name;
    String custID;

    public Customer(String name, String custID) {
        this.name = name;
        this.custID = custID;
    }
    public String getName() {
        return name;
    }
    public String getCustID() {
        return custID;
    }
}
//ManagingFiles.java

class ManagingFiles{
    public void saveData(Customer customer) {
        try{
            FileWriter fw = new FileWriter(customer.getName()+".txt");
            fw.write("the customer name is "+ customer.getName() + "\t");
            fw.write("the customer id is "+ customer.getCustID() + "\t");
            System.out.println("the data is saved in the file with your name");
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

public class Task1 {
    //SRP_Implementation

        public static void main(String[] args) {
            Customer cobj = new Customer("shirisha", "C001");
            ManagingFiles mobj = new ManagingFiles();
            mobj.saveData(cobj);
            System.out.println("SRP implemented:");
            System.out.println("Customer class is only responsible for holding customer data");
            System.out.println("ManagingFiles class is responsible for saving data to a file");
        }

}







/*
// Without SRP i.e. SRP violation code
     class Customer {
        String name;
        String custID;

        public Customer(String name, String custID) {
            this.name = name;
            this.custID = custID;
        }
        public String getName() {
            return name;
        }
        public String getCustID() {
            return custID;
        }
        }
        public void saveData() {
            try{
                FileWriter fw = new FileWriter(name+".txt");
                fw.write("the customer name is "+ name + "\t");
                fw.write("the customer id is "+ custID + "\t");
                System.out.println("the data is saved in the file with your name");
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
public class Task1 {
    public static void main(String[] args) {
        Customer cobj = new Customer(" shirisha" , "C001");
        cobj.saveData();
    }

}*/
