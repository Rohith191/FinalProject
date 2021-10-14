package com.rohit.cms.articles;


import com.rohit.cms.models.CmsCommand;
import com.rohit.cms.user.UserService;

public class ListArticlesCommand extends ArticlesCommon implements CmsCommand{
	
	public ListArticlesCommand(ArticlesService articlesSvc, UserService usersSvc) 
	{
		super(articlesSvc, usersSvc);
	}
	
	@Override
	public void runCommand() {
		if(!checkState())
			return;
		
	}
	
	

}
