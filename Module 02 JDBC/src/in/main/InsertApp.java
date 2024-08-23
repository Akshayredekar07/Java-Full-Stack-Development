package in.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql:///octbatch"; 
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection object is created...");

        Statement statement = connection.createStatement();
        System.out.println("Statement object is created...");

        String sqlDeleteQuery = "DELETE FROM Student WHERE id=5";
		int rowAffected = statement.executeUpdate(sqlDeleteQuery);
        System.out.println("No of row affected:"+rowAffected);

        statement.close();
        connection.close();
		System.out.println("Closing the resources!...");
    }
}




