package com.mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.common.util.LogRecord;
import com.mybatis.mapper.IUserOperation;
import com.mybatis.model.Article;
import com.mybatis.model.User;
import com.mybatis.model.form.UserForm;
import com.mybatis.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService    userService;

    @Autowired
    IUserOperation iUserOperation;

    @RequestMapping("/index.html")
    public String listall(HttpServletRequest request, HttpServletResponse response, Model model) {
        //        List<Article> articles = userService.getArticlesByUserId(3);
        //        for(Article article : articles){
        //            System.out.println(article.getContent());
        //        }
        //        model.addAttribute("articles", articles);
        model.addAttribute("userForm", new UserForm());
        return "index";
    }

    @RequestMapping("/test.html")
    public @ResponseBody User test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Article> articles = userService.getArticlesByUserId(2);
        LogRecord.info("frank love jade");
        User user = articles.get(0).getUser();
        user.setUserAge("25");
        return user;
    }
}
