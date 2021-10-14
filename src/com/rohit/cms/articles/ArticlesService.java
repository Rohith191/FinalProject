package com.rohit.cms.articles;

import java.util.List;
import com.rohit.cms.main.CmsObserver;
import com.rohit.cms.models.Article;
import com.rohit.cms.models.CmsObserverSubject;

public class ArticlesService implements CmsObserverSubject {
	private CmsObserver observer;
	public ArticlesService() {
		
	}
	
	public void displayArticles() {
		List<Article> articles = ArticlesPersistance.getInstance().getArticles();
		for(var article : articles) {
			//TODO: print
		}
	}
	
	String getState() {
		return this.observer.getState();
	}

	@Override
	public void addObserver(CmsObserver observer) {
		this.observer = observer;	
	}
	
	@Override
	public void notifyObserver(String s) {
		this.observer.setState(s);
	}

	public void listArticlesMenu() {
		String menu = "Use any of the following commands to use articles in this cms: \n";
		menu += "'list' to view all articles\n";
		menu += "'edit' to edit an article\n";
		menu += "'new' to create an article\n";
		menu += "'delete' to delete an article\n";
		System.out.println(menu);
		this.notifyObserver("articles");
	}
}
