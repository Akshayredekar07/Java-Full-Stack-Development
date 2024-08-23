package in.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//JDBC4.X autoloading feature is enabled
public class SelectApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Step 1: Load and register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Loading the driver");

        // Step 2: Establish the connection
        //String url = "jdbc:mysql://localhost:3306/octbatch";
        String url = "jdbc:mysql:///octbatch"; 
        //localhost:3306
        //not required if database is installed with default port number in local machine
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection object is created");

        // Step 3: Create a statement object and send the query
        Statement statement = connection.createStatement();
        System.out.println("Statement object is created");

        // Step 4: Execute the query and process the ResultSet
        String sqlSelectQuery = "SELECT id, name, age FROM Student";
        ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
        System.out.println("ResultSet object is created");

        System.out.println("ID\tNAME\tAGE");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id + "\t" + name + "\t" + age);
        }

        // Step 6: Close the ResultSet, Statement, and Connection objects
        resultSet.close();
        statement.close();
        connection.close();
    }
}


