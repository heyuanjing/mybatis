package com.mybatis.service;

import java.util.List;

import com.mybatis.model.Article;
import com.mybatis.model.User;

public interface UserService {

    List<Article> getArticlesByUserId(int userId);
    
    User getUserById(int id);
    
    void updateUser(User user);
    
    void deleteUser(int id);
    
    void addUser(User user);
    
}
