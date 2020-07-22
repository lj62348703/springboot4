package com.service;

import com.github.pagehelper.PageInfo;
import com.entity.Article;

public interface IArticleService {
	PageInfo<Article> findAll(Integer pageNum, Integer pageSize);
	
	PageInfo<Article> findAllByArticleType(Integer article_type_id, Integer pageNum, Integer pageSize);
	
	Article findById(Integer article_id);
	
	int addArticle(Article article);
	
	int delete(Integer article_id);
	
	int update(Article article);
}	
