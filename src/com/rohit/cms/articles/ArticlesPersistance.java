package com.rohit.cms.articles;

import java.util.List;

import com.rohit.cms.models.Article;

public interface ArticlesPersistance {

	List<Article> getArticles();

	void addArticle(Article article);

	void deleteArticle(long id);

	void updateArticle(Article article);
	
	int getArticlesCount();

}