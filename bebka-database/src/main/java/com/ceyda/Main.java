package com.ceyda;

import com.ceyda.DAO.UserDAO;
import com.ceyda.DAO.UserDAOImpl;
import com.ceyda.config.DataBaseConfig;
import com.ceyda.config.DataBaseConnecterConfig;
import com.ceyda.user.User;

import java.sql.*;

import static com.ceyda.config.DataBaseConnecterConfig.connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
           try{

               DataBaseConnecterConfig.setConnection();
               Connection connection=DataBaseConnecterConfig.getConnection();

            UserDAO userDAO=new UserDAOImpl(connection);
 //              userDAO.createTable();
 //              User user=new User(1,"Ceyda",22);
 //                            userDAO.save(user);
               System.out.println("Kayıtlı Kullanıcılar:");
               userDAO.findAll();

           } catch (Exception e) {
               e.printStackTrace();
           }finally {
               DataBaseConnecterConfig.closeConnection();
           }


    }
}