package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String jdbcURL = "jdbc:mysql://localhost:3306/bibliotheque";
        String user = "root";
        String pass = "";

       /* DBMS: MySQL (ver. 5.7.33)
        Case sensitivity: plain=lower, delimited=lower
        Driver: MySQL Connector/J (ver. mysql-connector-java-8.0.25 (Revision: 08be9e9b4cba6aa115f9b27b215887af40b159e0), JDBC4.2)
        Ping: 78 ms
        SSL: yes*/
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,user,pass);
            System.out.printf("Ajouter Succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
