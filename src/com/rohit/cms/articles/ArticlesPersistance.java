package com.rohit.cms.articles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.rohit.cms.models.Article;

public class ArticlesPersistance {
	private static ArticlesPersistance instance;
	private ArticlesPersistance() {
		articles = new ArrayList<Article>();
	}
	public static synchronized ArticlesPersistance getInstance() {
		if (instance == null) {
			instance = new ArticlesPersistance();
		}
		return instance;
	}
	
	private List<Article> articles;
	
	public List<Article> getArticles(){
		articles.sort(new IdComparator());
		return articles;
	}
	
	public void addArticle(Article article)
	{
		articles.add(article);
	}
	
	public void deleteArticle(int id)
	{
		articles.removeIf(a -> a.id == id);
	}
	
	public void updateArticle(Article article)
	{
		deleteArticle(article.id);
		addArticle(article);
	}
	class IdComparator implements Comparator<Article> {
	    @Override
	    public int compare(Article a, Article b) {
	        return a.id < b.id ? -1 : a.id == b.id ? 0 : 1;
	    }
	}
}
