package com.rohit.cms.articles;

import com.rohit.cms.models.CmsCommand;

public class ArticlesCommand extends ArticlesCommon implements CmsCommand {
	public ArticlesCommand(ArticlesService articlesSvc)
	{
		super(articlesSvc);
	}
	@Override
	public void runCommand() {
		articlesSvc.listArticlesMenu();
		return;
	}

}
