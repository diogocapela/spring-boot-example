package com.diogocapela.service;

import com.diogocapela.dao.ArticlesDAO;
import com.diogocapela.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArticlesService {

    @Autowired
    @Qualifier("fakeData")
    private ArticlesDAO articlesDAO;

    public Collection<Article> getAllArticles(){
        return this.articlesDAO.getAllArticles();
    }

    public Article getArticleById(int id){
        return this.articlesDAO.getArticleById(id);
    }


    public void removeArticleById(int id) {
        this.articlesDAO.removeArticleById(id);
    }

    public void updateArticle(Article student){
        this.articlesDAO.updateArticle(student);
    }

    public void insertArticle(Article student) {
        this.articlesDAO.insertArticleToDb(student);
    }
}
