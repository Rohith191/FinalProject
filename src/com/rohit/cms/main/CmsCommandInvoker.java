package com.rohit.cms.main;

import java.util.HashMap;
import java.util.Map;
import com.rohit.cms.articles.*;
import com.rohit.cms.models.*;
import com.rohit.cms.user.*;

public class CmsCommandInvoker {
	Map<String, CmsCommand> commands;
	private UserService userSvc;
	private ArticlesService articleSvc;
	private CmsObserver locationObserver;

	public CmsCommandInvoker(UserService userSvc, ArticlesService articleSvc) {
		this.userSvc = userSvc;
		this.articleSvc = articleSvc;
		this.locationObserver = new CmsLocationObserver();
		userSvc.addObserver(locationObserver);
		articleSvc.addObserver(locationObserver);
		mapCommands();
	}

	public CmsObserver getObserver() {
		return this.locationObserver;
	}

	void mapCommands() {
		commands = new HashMap<String, CmsCommand>();
		commands.put("login", new LoginCommand(userSvc));
		commands.put("logoff", new LogoffCommand(userSvc));
		commands.put("articles", new ArticlesCommand(articleSvc));
		commands.put("list", new ListArticlesCommand(articleSvc));
		commands.put("new", new NewArticleCommand(articleSvc));
		commands.put("delete", new DeleteArticleCommand(articleSvc));
		commands.put("edit", new EditArticleCommand(articleSvc));
	}

	public void start() {
		while (true) {
			var location = "";
			if (locationObserver.getLocation() == "logged_in") {
				location = "logged_in [" + userSvc.getUserName() + "]";
			} else {
				location = locationObserver.getLocation();
			}
			String inputText = CmsUtil.askForStringSameLine("cms (" + location + ") > ");
			if (inputText.equalsIgnoreCase("exit"))
				break;
			this.executeCommand(inputText, locationObserver.getLocation());
		}
	}

	public void executeCommand(String command, String currentLocation) {
		if (!validateLocation(command, currentLocation))
			return;
		var cmd = getCommand(command);
		if (cmd != null) {
			cmd.runCommand();
		}
	}

	public CmsCommand getCommand(String command) {
		var cmd = commands.get(command);
		return cmd;
	}

	public boolean validateLocation(String command, String currentLocation) {
		if (command.equalsIgnoreCase("login")) {
			if (currentLocation == "not_logged_in")
				return true;
			else {
				System.out.println("You seem to be logged in already! ");
				return false;
			}
		}
		if (command.equalsIgnoreCase("logoff")) {
			if (currentLocation == "logged_in" || currentLocation == "articles")
				return true;
			else {
				System.out.println("Current location is in-valid for logoff command: " + currentLocation
						+ ". It needs to be 'logged_in' or 'articles' ");
				return false;
			}
		}
		if (command.equalsIgnoreCase("articles")) {
			if (currentLocation == "logged_in")
				return true;
			else {
				System.out.println("Please login before using articles section!");
				return false;
			}
		}
		if (command.equalsIgnoreCase("list") || command.equalsIgnoreCase("edit") || command.equalsIgnoreCase("new")
				|| command.equalsIgnoreCase("delete")) {
			if (currentLocation == "articles")
				return true;
			else {
				System.out.println(
						"Please enter articles section by using 'articles' command. Current location is in-valid for '"
								+ command + "': " + currentLocation);
				return false;
			}
		}
		System.out.println("Unrecognized command! " + command);
		return false;
	}
}
