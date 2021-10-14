package com.rohit.cms.main;

import java.util.HashMap;
import java.util.Map;

import com.rohit.cms.articles.*;
import com.rohit.cms.models.*;
import com.rohit.cms.user.LoginCommand;
import com.rohit.cms.user.UserService;

public class CmsCommandInvoker {
	Map<String, CmsCommand> commands;
	private UserService userSvc;
	private ArticlesService articleSvc;
	
	public CmsCommandInvoker(UserService userSvc, ArticlesService articleSvc)
	{
		this.userSvc = userSvc;
		this.articleSvc = articleSvc;
		mapCommands();
	}
	
	void mapCommands() 
	{
		commands = new HashMap<String, CmsCommand>();
		commands.put("login", new LoginCommand(userSvc));
		commands.put("articles", new ArticlesCommand(articleSvc, userSvc));
		commands.put("list", new ListArticlesCommand(articleSvc, userSvc));
	}
	
	public void executeCommand(String command, String currentState) {
		var cmd = commands.get(command);
		if(cmd != null) {
			cmd.runCommand();
		}else {
			System.out.println("Unrecognized command: "+command);
		}
	}
}
