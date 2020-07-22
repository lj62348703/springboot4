package com.mapper;

import com.entity.ArticleType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTypeMapper {

    @Select("select * from article_type")
    List<ArticleType> findAll();

    @Select("select * from article_type where article_type_id = #{0}")
    ArticleType findById(Integer article_type_id);

    @Insert("insert into article_type(article_type_name,article_type_upid) values(#{article_type_name},#{article_type_upid})")
    int add(ArticleType articleType);

    @Delete("delete from article_type where article_type_id = #{0}")
    int delete(Integer article_type_id);

    @Update("update article_type set article_type_name = #{article_type_name}, article_type_upid = #{article_type_upid} where article_type_id = #{article_type_id}")
    int update(ArticleType articleType);
}
