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
//resultset verileri listelemek için kullanılıyor. rs.next()ile sıra sıra dolaşacak.
        String selectSQL="SELECT*FROM users";
try{
    Connection connection=DriverManager.getConnection(DataBaseConfig.DATABES_URL,DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
    PreparedStatement preparedStatement= connection.prepareStatement(selectSQL);
   ResultSet resultSet= preparedStatement.executeQuery();

    while (resultSet.next()){
        System.out.println(resultSet.getString("name"));
        System.out.println(resultSet.getString("email"));
    }
    }catch(Exception e){
    e.printStackTrace();
    }

//Update İşlemi
        String updateSQL="UPDATE users SET name=? WHERE id=?";
try(Connection connection=DriverManager.getConnection(DataBaseConfig.DATABES_URL,DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
PreparedStatement preparedStatement= connection.prepareStatement(InsertSQL)){
    preparedStatement.setString(1,"Elif");
    preparedStatement.setString(2,"elif@gmail.com");
    preparedStatement.executeUpdate();
        System.out.println("Kayıt Başarıyla Güncellendi.");

}catch(Exception e){
    e.printStackTrace();
}
//Delete işlemi
        String deleteSQL="DELETE FROM users WHERE id=?";
try(Connection connection=DriverManager.getConnection(DataBaseConfig.DATABES_URL,DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
PreparedStatement preparedStatement=connection.prepareStatement(deleteSQL)){
    preparedStatement.setInt(1,5);
   int deleted= preparedStatement.executeUpdate();
    if(deleted>0){
        System.out.println("Kayıt Başarıyla Silindi.");
    }else{
        System.out.println("Kayıtlı Kullanıcı Bulunamadı.");
    }
} catch (Exception e) {
   e.printStackTrace();
}



    }
}