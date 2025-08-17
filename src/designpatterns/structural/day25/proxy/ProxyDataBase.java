package designpatterns.structural.day25.proxy;

// Proxy Class
public class ProxyDataBase implements DatabaseExecute {
    private String desig;
    private DataBase db;

    public ProxyDataBase(String desig) {
        this.desig = desig;
        this.db = new DataBase();
    }

    @Override
    public void executeQuery(String queryType) {
        if (queryType.equalsIgnoreCase("Delete") && !desig.equals("ADMIN")) {
            System.out.println("You don't have permission to DELETE");
            return;
        }

        if (queryType.equalsIgnoreCase("Write") && !(desig.equals("ADMIN") || desig.equals("HR"))) {
            System.out.println("You don't have permission to WRITE");
            return;
        }


        db.execute(queryType, desig);


    }
}
