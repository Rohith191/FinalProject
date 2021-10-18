package com.rohit.cms.main;

import com.rohit.cms.articles.ArticlesPersistance;
import com.rohit.cms.articles.ArticlesService;
import com.rohit.cms.articles.JsonArticlesPersistance;
import com.rohit.cms.user.UserService;


public class RohitCms {
	public void start() {
		UserService userService = new UserService();
		ArticlesPersistance persistance = JsonArticlesPersistance.getInstance();
		ArticlesService articleService = new ArticlesService(userService, persistance);
		CmsCommandInvoker executor = new CmsCommandInvoker(userService, articleService);
		CmsUtil.printWelcomeBanner();
		System.out.println("Use 'login' to start, 'exit' to quit CMS anytime! ");
		System.out.println();
		executor.start();
		System.out.println("Thank you for using Rohit CMS! Good Bye!");
	}
}
