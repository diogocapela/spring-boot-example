package com.diogocapela.dao;

import com.diogocapela.model.Article;

import java.util.Collection;

public interface ArticlesDAO {
    Collection<Article> getAllArticles();

    Article getArticleById(int id);

    void removeArticleById(int id);

    void updateArticle(Article student);

    void insertArticleToDb(Article student);
}
