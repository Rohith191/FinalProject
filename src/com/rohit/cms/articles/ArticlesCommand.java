package com.rohit.cms.articles;

import com.rohit.cms.models.CmsCommand;
import com.rohit.cms.user.UserService;

public class ArticlesCommand extends ArticlesCommon implements CmsCommand {
	public ArticlesCommand(ArticlesService articlesSvc, UserService usersSvc)
	{
		super(articlesSvc, usersSvc);
	}
	@Override
	public void runCommand() {
		if(!usersSvc.isActive()) {
			System.out.println("Please login first!");
			return;
		}
		articlesSvc.listArticlesMenu();
		return;
	}

}
