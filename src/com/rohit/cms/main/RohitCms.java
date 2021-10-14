package com.rohit.cms.main;

import java.util.Scanner;

import com.rohit.cms.articles.ArticlesService;

import com.rohit.cms.user.UserService;


public class RohitCms {
	public void start() {
		//perform user login/logoff commands
		//UserService.start();
		UserService userService = new UserService();
		ArticlesService articleService = new ArticlesService();
		CmsObserver stateObserver = new CmsStateObserver();
		userService.addObserver(stateObserver);
		articleService.addObserver(stateObserver);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Rohit CMS! Use 'login' to start, 'exit' to quit CMS! ");
		CmsCommandInvoker executor = new CmsCommandInvoker(userService, articleService);
		while(true) {
			var state = "";
			if(stateObserver.getState() == "logged_in") {
				state = "logged_in ["+userService.getUserName()+"]";
			}else {
				state = stateObserver.getState();
			}
			String inputText = CmsUtil.askForStringSameLine("cms ("+state+") > ");
			if(inputText.compareToIgnoreCase("exit") == 0)
				break;
			executor.executeCommand(inputText, stateObserver.getState());
		}
		input.close();
		System.out.println("Thank you for using Rohit CMS! Good Bye!");
	}
}
