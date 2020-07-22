package com.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ArticleType implements Serializable {
    private Integer article_type_id;
    @NotNull
    @NotEmpty
    private String article_type_name;
    private String article_type_upid;

    public Integer getArticle_type_id() {
        return article_type_id;
    }

    public void setArticle_type_id(Integer article_type_id) {
        this.article_type_id = article_type_id;
    }

    public String getArticle_type_name() {
        return article_type_name;
    }

    public void setArticle_type_name(String article_type_name) {
        this.article_type_name = article_type_name;
    }

    public String getArticle_type_upid() {
        return article_type_upid;
    }

    public void setArticle_type_upid(String article_type_upid) {
        this.article_type_upid = article_type_upid;
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "article_type_id=" + article_type_id +
                ", article_type_name='" + article_type_name + '\'' +
                ", article_type_upid='" + article_type_upid + '\'' +
                '}';
    }
}
