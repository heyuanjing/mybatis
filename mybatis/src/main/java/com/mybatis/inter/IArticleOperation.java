package com.mybatis.inter;

import java.util.List;

import com.mybatis.model.Article;

public interface IArticleOperation {

    public List<Article> getUserArticles(int id);
}
