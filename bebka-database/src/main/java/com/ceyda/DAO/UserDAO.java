package com.ceyda.DAO;

import com.ceyda.user.User;

public interface UserDAO {
    void createTable();
    void save(User user);
void findAll();

}
