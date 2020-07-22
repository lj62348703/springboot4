package com.service;

import com.entity.ArticleType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IArticleTypeService {
    List<ArticleType> findAll();

    PageInfo<ArticleType> findAllPage(Integer pageNum,Integer pageSize);

    ArticleType findById(Integer article_type_id);

    int add(ArticleType articleType);

    int delete(Integer article_type_id);

    int update(ArticleType articleType);
}
