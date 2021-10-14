package com.rohit.cms.articles;

import com.rohit.cms.user.UserService;

public class ArticlesCommon {
	
	protected ArticlesService articlesSvc;
	protected UserService usersSvc;
	protected ArticlesCommon(ArticlesService articlesSvc, UserService usersSvc)
	{
		this.articlesSvc = articlesSvc;
		this.usersSvc = usersSvc;
		
	}
	protected boolean checkState() {
		if(!usersSvc.isActive()) {
			System.out.println("Please login first!");
			return false;
		}
		if(articlesSvc.getState() != "articles") {
			System.out.println("Please enter articles section by typing in 'articles' command!");
			return false;	
		}
		return true;
	}
}
