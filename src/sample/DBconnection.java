package sample;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
    String server = "localhost";
    int port = 3306;
    String user = "admin";
    String password = "admin";
    String database = "project_gui";
    String jdbcurl;


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
            return con;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return  null;
        }

    }
}


