package com.example.datasource;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


// open for extension , closed for modification

// Factory class
public class SQLConnectionFactory {

    private final static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/datasource.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        // step-1: register jdbc-driver
        try {
//          DriverManager.registerDriver("");
            Class.forName(properties.getProperty("datasource.driver-class-name"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Factory method
    /*
        why we need Factory,
        => isolate complex object creation logic from regular-code
    */
    public static Connection getConnection() throws SQLException {
        // step-2: create db-connection
        String url = properties.getProperty("datasource.url");
        String username = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");
        return DriverManager.getConnection(url, username, password);
    }

}
