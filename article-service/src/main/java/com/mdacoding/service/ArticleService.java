package com.mdacoding.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mdacoding.dto.Article;

@Service
public class ArticleService {
      private List<Article> articles = new ArrayList<>();

    public Article addArticle(Article article) {
        articles.add(article);
        return article;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
}

