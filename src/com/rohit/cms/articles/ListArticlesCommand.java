package com.rohit.cms.articles;


import com.rohit.cms.models.CmsCommand;

public class ListArticlesCommand extends ArticlesCommon implements CmsCommand{
	
	public ListArticlesCommand(ArticlesService articlesSvc) 
	{
		super(articlesSvc);
	}
	
	@Override
	public void runCommand() {
		articlesSvc.displayArticles();
	}
	
	

}
