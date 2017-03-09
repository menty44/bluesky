package com.javawebtutor.dao;

import java.util.List;
import com.javawebtutor.model.User;
 
/**
 *
 * @author Vikram
 */
public interface UserDao {
    
    public void saveUser (User user);
    public List<User> showAll();
    public void updateUser (int userid, String name, String phoneno, String email, String branch, String location, String vatno, String krapin);
    public void deleteUser (User user);
    
    
}