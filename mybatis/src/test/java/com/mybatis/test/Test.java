package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.mapper.IArticleOperation;
import com.mybatis.mapper.IUserOperation;
import com.mybatis.model.Article;
import com.mybatis.model.User;

public class Test {
    private static ApplicationContext ctx;
    
    private static SqlSessionFactory sqlSessionFactory;
    
        static {
            ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
            sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
        }


    //    public static void main(String[] args) {
    //        SqlSession session = sqlSessionFactory.openSession();
    //        try {
    //            User user = (User) session.selectOne("com.mybatis.mapper.UserMapper.selectUserByID", 1);
    //            System.out.println(user.getUserAddress());
    //            System.out.println(user.getUserName());
    //        } finally {
    //            session.close();
    //        }
    //    }

    public static void main(String[] args) {
        Test testUser=new Test();
        testUser.getUserArticles(3);;
    }
    
   
    public void getUserList(String userName){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);           
            List<User> users = userOperation.selectUsers(userName);
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
            }
            
        } finally {
            session.close();
        }
    }
    
    public void addUser(){
        User user=new User();
        user.setUserAddress("世纪大道");
        user.setUserName("frank");
        user.setUserAge("25");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }
    
    public void updateUser(){
        //先得到用户,然后修改，提交。
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(1);            
            user.setUserAddress("原来是魔都的浦东创新园区");
            userOperation.updateUser(user);
            session.commit();
            
        } finally {
            session.close();
        }
    }
    
    public void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);           
            userOperation.deleteUser(id);
            session.commit();            
        } finally {
            session.close();
        }
    }
    
    public void getUserArticles(int userid){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IArticleOperation articleOperation=session.getMapper(IArticleOperation.class);           
            List<Article> articles = articleOperation.getUserArticles(userid);
            for(Article article:articles){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getUserName()+":地址:"+
                         article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }
    
}
