package com.ceyda.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnecterConfig {
    public static Connection connection;

    public static void setConnection(){
        try{
            connection= DriverManager.getConnection(DataBaseConfig.DATABES_URL,DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void closeConnection(){
        try{
            connection.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
