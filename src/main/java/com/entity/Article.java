package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer article_id;
	@NotNull
	private String article_title;
	@NotNull
	private String article_content;
	private String article_image_url;
	private Date article_publish_time;
	
	private Integer article_type_id;
	
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_image_url() {
		return article_image_url;
	}
	public void setArticle_image_url(String article_image_url) {
		this.article_image_url = article_image_url;
	}
	
	public Date getArticle_publish_time() {
		return article_publish_time;
	}
	public void setArticle_publish_time(Date article_publish_time) {
		this.article_publish_time = article_publish_time;
	}
	
	
	public Integer getArticle_type_id() {
		return article_type_id;
	}
	public void setArticle_type_id(Integer article_type_id) {
		this.article_type_id = article_type_id;
	}
	
	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", article_title=" + article_title + ", article_content="
				+ article_content + ", article_image_url=" + article_image_url + ", article_publish_time="
				+ article_publish_time + ", article_type_id=" + article_type_id + "]";
	}
}
