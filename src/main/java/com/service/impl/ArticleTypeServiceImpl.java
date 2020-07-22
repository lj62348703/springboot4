package com.service.impl;

import com.entity.ArticleType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ArticleTypeMapper;
import com.service.IArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTypeServiceImpl implements IArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;
    @Override
    public List<ArticleType> findAll() {
        return articleTypeMapper.findAll();
    }

    @Override
    public PageInfo<ArticleType> findAllPage(Integer pageNum,Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleType> list = articleTypeMapper.findAll();
        PageInfo<ArticleType> info = new PageInfo<ArticleType>(list);
        return info;
    }

    @Override
    public ArticleType findById(Integer article_type_id) {
        return article_type_id == null ? null : articleTypeMapper.findById(article_type_id);
    }

    @Override
    public int add(ArticleType articleType) {
        return articleTypeMapper.add(articleType);
    }

    @Override
    public int delete(Integer article_type_id) {
        return article_type_id == null ? 0 : articleTypeMapper.delete(article_type_id);
    }

    @Override
    public int update(ArticleType articleType) {
        return articleTypeMapper.update(articleType);
    }
}
