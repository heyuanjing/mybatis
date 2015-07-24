package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.mybatis.common.annotation.MyCacheable;
import com.mybatis.mapper.IArticleOperation;
import com.mybatis.mapper.IUserOperation;
import com.mybatis.model.Article;
import com.mybatis.model.User;
import com.mybatis.service.UserService;

@Service
//@Cacheable(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IArticleOperation articleOperation;

    @Autowired
    private IUserOperation    userOperation;
    
    /**
     * CachePut每次都会执行方法，并将结果保存到缓存中
     * @see com.mybatis.service.UserService#getArticlesByUserId(int)
     */
    @CachePut(value = "cache1", key = "#userId")
    public List<Article> getArticlesByUserId(int userId) {
        return articleOperation.getUserArticles(userId);
    }

    /**
     * value:缓存名称  key:缓存保存的结果对应的key conditon:缓存发生的条件
     * @see com.mybatis.service.UserService#getUserById(int)
     */
    @Cacheable(value = { "cache2", "cache3" }, key = "#id", condition = "#id/2==0")
    public User getUserById(int id) {
        return userOperation.selectUserByID(id);
    }

    /**
     * allEntries=true 忽略key清除所有缓存  
     * beforeInvocation = true  调用该方法之前清除缓存
     * @see com.mybatis.service.UserService#updateUser(com.mybatis.model.User)
     */
    @CacheEvict(value = { "cache2", "cache3" }, allEntries = true, beforeInvocation = true)
    public void updateUser(User user) {
        userOperation.updateUser(user);
    }

    /**
     * @Caching 集成3个操作
     * @see com.mybatis.service.UserService#deleteUser(int)
     */
    @Caching(cacheable = @Cacheable(value = ""), evict = @CacheEvict(value = { "cache1", "cache2", "cache3" }), put = @CachePut(value = ""))
    public void deleteUser(int id) {
        userOperation.deleteUser(id);
    }

    /**
     * 自定义注解
     * @see com.mybatis.service.UserService#addUser(com.mybatis.model.User)
     */
    @MyCacheable
    public void addUser(User user) {
        userOperation.addUser(user);
        
    }
    
    

}
