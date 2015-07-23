package com.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.inter.IArticleOperation;
import com.mybatis.inter.IUserOperation;
import com.mybatis.model.Article;
import com.mybatis.model.User;

@Controller
@RequestMapping("/article")
public class UserController {
    
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    IArticleOperation articleMapper;
    
    @Autowired
    IUserOperation iUserOperation;

    @RequestMapping("/index.html")
    public String listall(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Article> articles = articleMapper.getUserArticles(2);
        for(Article article : articles){
            System.out.println(article.getContent());
        }
        model.addAttribute("articles", articles);
        return "index";
    }
}
