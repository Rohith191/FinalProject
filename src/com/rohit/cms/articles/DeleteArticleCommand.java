package com.rohit.cms.articles;

import com.rohit.cms.models.CmsCommand;

public class DeleteArticleCommand extends ArticlesCommon implements CmsCommand{
	
	public DeleteArticleCommand(ArticlesService articlesSvc) 
	{
		super(articlesSvc);
	}
	
	@Override
	public void runCommand() {
		articlesSvc.deleteArticle();
	}

}
