package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.entity.Article;
import com.mapper.ArticleMapper;
import com.service.IArticleService;

@Service
public class ArticleSerivceImpl implements IArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> findAll(Integer pageNum,Integer pageSize) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = articleMapper.findAll();
		PageInfo<Article> info = new PageInfo<Article>(list);
		return info;
	}

	@Override
	public PageInfo<Article> findAllByArticleType(Integer article_type_id,Integer pageNum, Integer pageSize) {
		if(article_type_id == null) return null;
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = articleMapper.findAllByArticleType(article_type_id);
		PageInfo<Article> info = new PageInfo<Article>(list);
		return info;
	}

	@Override
	public Article findById(Integer article_id) {
		return article_id == null ? null : articleMapper.findById(article_id);
	}

	@Override
	public int addArticle(Article article) {
		return articleMapper.addArticle(article);
	}

	@Override
	public int delete(Integer article_id) {
		return article_id == null ? 0 : articleMapper.delete(article_id);
	}

	@Override
	public int update(Article article) {
		return articleMapper.update(article);
	}

}
