package com.ceyda.DAO;

import com.ceyda.user.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection){
        this.connection=connection;
    }
    @Override
    public void createTable() {
        String sql="CREATE TABLE IF NOT EXISTS userss("+
                "id SERIAL PRIMARY KEY,"+
                "name VARCHAR(50) ,"+
                "age VARCHAR(50))";
        try(Statement statement= connection.createStatement()){
            statement.execute(sql);
            System.out.println("Tablo Oluşturuldu.");
        }catch (SQLException e){
            throw new RuntimeException("Tablo Oluşturulamadı.");
        }

    }

    @Override
    public void save(User user) {
String sql="INSERT INTO userss(name,age) VALUES(?,?)";
try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
    preparedStatement.setString(1, user.getName());
    preparedStatement.setInt(2,user.getAge());
    preparedStatement.executeUpdate();
    System.out.println("Kayıt Eklendi.");
}catch (SQLException e){
    throw new RuntimeException("Kayıt Oluşturulamadı.");
}
    }

    @Override
    public void findAll() {

    }

    public void findall(){
        String sql="SELECT*FROM userss";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery()){
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                System.out.println("Kayıt Bulundu.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }

    }
}
