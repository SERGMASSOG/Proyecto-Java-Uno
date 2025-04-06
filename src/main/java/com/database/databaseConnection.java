package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    private  static  final  String URL = "jdbc:mysql://localhost:3306/base_proyecto";
    private  static  final  String USER = "root";
    private  static  final  String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //Carga del Drive
            return  DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e){
            throw new SQLException("Error:No se encontro el drive de Mysql", e);
        }
    }
}
