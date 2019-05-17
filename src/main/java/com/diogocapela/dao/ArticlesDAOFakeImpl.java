package com.diogocapela.dao;

import com.diogocapela.model.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class ArticlesDAOFakeImpl implements ArticlesDAO {

    private static Map<Integer, Article> articles;

    static {

        articles = new HashMap<Integer, Article>(){

            {
                put(1, new Article(1, "Article 1", "Content"));
                put(2, new Article(2, "Article 2", "Content"));
                put(3, new Article(3, "Article 3", "Content"));
            }
        };
    }

    @Override
    public Collection<Article> getAllArticles(){
        return this.articles.values();
    }

    @Override
    public Article getArticleById(int id){
        return this.articles.get(id);
    }

    @Override
    public void removeArticleById(int id) {
        this.articles.remove(id);
    }

    @Override
    public void updateArticle(Article article){
        Article s = articles.get(article.getId());
        s.setContent(article.getContent());
        s.setTitle(article.getTitle());
        articles.put(article.getId(), article);
    }

    @Override
    public void insertArticleToDb(Article article) {
        this.articles.put(article.getId(), article);
    }
}
