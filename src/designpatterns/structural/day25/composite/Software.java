package designpatterns.structural.day25.composite;

// Leaf Component: Software Department
public class Software implements Company {
    private int id;
    private String name;

    public Software(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void displayName() {
        System.out.println("Department - ID: " + id + ", Name: " + name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
