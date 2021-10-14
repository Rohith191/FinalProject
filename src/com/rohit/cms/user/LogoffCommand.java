package com.rohit.cms.user;

import com.rohit.cms.models.CmsCommand;

public class LogoffCommand implements CmsCommand{
	
	private UserService userService;

	public LogoffCommand(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void runCommand() {
		this.userService.logoffUser();
	}
}