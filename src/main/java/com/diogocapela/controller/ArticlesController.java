package com.diogocapela.controller;

import com.diogocapela.model.Article;
import com.diogocapela.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Article> getAllArticles(){
        return articlesService.getAllArticles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Article getArticleById(@PathVariable("id") int id){
        return articlesService.getArticleById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteArticleById(@PathVariable("id") int id){
        articlesService.removeArticleById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteArticleById(@RequestBody Article article){
        articlesService.updateArticle(article);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertArticle(@RequestBody Article article){
        articlesService.insertArticle(article);
    }
}
