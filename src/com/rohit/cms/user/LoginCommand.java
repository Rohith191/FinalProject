package com.rohit.cms.user;

import com.rohit.cms.models.CmsCommand;

public class LoginCommand implements CmsCommand{
	
	private UserService userService;

	public LoginCommand(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void runCommand() {
		this.userService.loginNewUser();
	}
}