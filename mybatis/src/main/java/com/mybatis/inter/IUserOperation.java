package com.mybatis.inter;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mybatis.model.User;

public interface IUserOperation {    

    public User selectUserByID(int id);
    
    public List<User> selectUsers(String userName);
    
    public void addUser(User user);
    
    public void updateUser(User user);
    
    public void deleteUser(int id);
    
}
