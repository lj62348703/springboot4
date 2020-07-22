package com.mapper;

import java.util.List;

import com.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entity.Article;

public interface ArticleMapper {
	@Select("select * from article")
	List<Article> findAll();
	
	@Select("select * from article where article_type_id=#{0}")
	List<Article> findAllByArticleType(Integer article_type_id);
	
	@Select("select * from article where article_id = #{0}")
	Article findById(Integer article_id);
	
	@Insert("insert into article(article_title,article_content,article_publish_time,article_image_url,article_type_id) "
			+ "values(#{article_title},#{article_content},#{article_publish_time},#{article_image_url},#{article_type_id})")
	int addArticle(Article article);
	
	@Delete("delete from article where article_id = #{0}")
	int delete(Integer article_id);
	
	@Update("update article set article_title=#{article_title},article_content=#{article_content},article_type_id=#{article_type_id}, "
			+ "article_image_url=#{article_image_url} where article_id=#{article_id}")
	int update(Article article);
	

}
