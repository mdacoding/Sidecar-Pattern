package com.mdacoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdacoding.dto.Article;
import com.mdacoding.service.ArticleService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/articles")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @SneakyThrows
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article savedArticle = articleService.addArticle(article);
        log.info("ArticleController::addArticle request {}", new ObjectMapper().writeValueAsString(article));
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }

    @SneakyThrows
    @GetMapping
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> articles = articleService.getArticles();
        log.info("ArticleController::getArticles response {}", new ObjectMapper().writeValueAsString(articles));
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
}
