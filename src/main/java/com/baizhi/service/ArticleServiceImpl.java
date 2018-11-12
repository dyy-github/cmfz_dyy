package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Override
    public void add(Article article) {
        articleDao.insert(article);
    }

    @Override
    public void remove(Article article) {
        articleDao.deleteById(article);
    }

    @Override
    public void modifyById(Article article) {
        articleDao.update(article);
    }

    @Override
    public Article findById(Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findPaging(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<Article> articles = articleDao.queryPaging(start, rows);
        return articles;
    }

    @Override
    public long findTotals() {
        return articleDao.queryTotals();
    }
}
