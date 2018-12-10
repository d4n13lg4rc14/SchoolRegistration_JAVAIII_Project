package sample;


import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

    public static void main(String[] args) {

        String jbcUrl="jdbc:mysql://localhost:3306/School_Registration?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Leinad34";

        try {
            System.out.println("Connecting to database: " + jbcUrl);

            Connection myConn = DriverManager.getConnection(jbcUrl, user, password);

            System.out.println("Connecting successful!!!");



        } catch (Exception exc ) {
            exc.printStackTrace();
        }
    }

}
