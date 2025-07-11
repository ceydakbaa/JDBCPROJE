package com.ceyda;

import com.ceyda.config.DataBaseConfig;

import java.sql.*;

import static com.ceyda.config.DataBaseConnecterConfig.connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
           String sql="CREATE TABLE IF NOT EXISTS users(" +
                   "id SERIAL PRIMARY KEY," +
                   "name VARCHAR(50)," +
                   "email VARCHAR(100))";

           try{
               Connection connection= DriverManager.getConnection(DataBaseConfig.DATABES_URL,DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
               Statement statement= connection.createStatement();
               statement.execute(sql);
               System.out.println("Table Created");
               statement.close();
               connection.close();
           }catch(Exception e ){
               e.printStackTrace();
           }
//VERİ EKLEME
        String InsertSQL="INSERT INTO users(name,email) VALUES(?,?)";
//hata almamak için try-catch kullanıyoruz.Çünkü connection bağlantımız try bloğunun içerisinde yer alıyor.
try{
    Connection connection=DriverManager.getConnection(DataBaseConfig.DATABES_URL,DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
    Statement statement=connection.createStatement();
    PreparedStatement preparedStatement= connection.prepareStatement(InsertSQL);
preparedStatement.setString(1,"Ceyda KABA");
preparedStatement.setString(2,"ceydakbaa@gmail.com");
preparedStatement.executeUpdate();
    System.out.println("Kayıt Oluşturuldu");
}catch(Exception e){
    e.printStackTrace();
}



    }
}