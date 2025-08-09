package ooad.day25;

// Proxy Design Pattern — Role-Based Database Operation Control

    // The Real Subject
    class DataBase {
        void execute(String query, String desig) {
            System.out.println("Query execution in process: " + query + " by " + desig);
        }
    }

    // Subject Interface
    interface DatabaseExecute {
        void executeQuery(String queryType);
    }

    // Proxy Class
    class ProxyDataBase implements DatabaseExecute {
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


    public class Task4{
    public static void main(String[] args) {
        System.out.println("Proxy Design Pattern - Structural DP\n");

        System.out.println("ADMIN Operations:");
        DatabaseExecute adminDB = new ProxyDataBase("ADMIN");
        adminDB.executeQuery("Delete");
        adminDB.executeQuery("Write");
        adminDB.executeQuery("Read");

        System.out.println("\nHR Operations:");
        DatabaseExecute hrDB = new ProxyDataBase("HR");
        hrDB.executeQuery("Delete");
        hrDB.executeQuery("Write");
        hrDB.executeQuery("Read");

        System.out.println("\nOTHER EMPLOYEE Operations:");
        DatabaseExecute employeeDB = new ProxyDataBase("OTHER EMPLOYEE");
        employeeDB.executeQuery("Delete");
        employeeDB.executeQuery("Write");
        employeeDB.executeQuery("Read");
    }
}
