package com.rohit.cms.articles;

import com.rohit.cms.models.CmsCommand;

public class NewArticleCommand extends ArticlesCommon implements CmsCommand{
	
	public NewArticleCommand(ArticlesService articlesSvc) 
	{
		super(articlesSvc);
	}
	
	@Override
	public void runCommand() {
		articlesSvc.createNewArticle();
	}

}
