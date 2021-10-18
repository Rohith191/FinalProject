package com.rohit.cms.articles;

import com.rohit.cms.models.CmsCommand;

public class EditArticleCommand extends ArticlesCommon implements CmsCommand{
	
	public EditArticleCommand(ArticlesService articlesSvc) 
	{
		super(articlesSvc);
	}
	
	@Override
	public void runCommand() {
		articlesSvc.editArticle();
	}

}
