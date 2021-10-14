package com.rohit.cms.models;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CmsUser {
	public String username;
	public String password;
	boolean isActiveUser;
	
	public void setActiveUser() {
		isActiveUser = true;
	}

	
	public void setInActive() {
		isActiveUser = false;
	}

	
	public void greet() {
		System.out.println("Hello "+username+"! You are now logged in. Go to articles section by using 'articles' command line. \n You can logoff by using 'logoff' command or exit completely by using 'exit' command at anytime");
	}

	
	public void bidGoodbye() {
		System.out.println("Goodbye "+username+"! See you again soon!");
	}

	
	public void saveToFile() {
		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(username));
		    writer.write(password);
		    writer.close();
		}
		catch (Exception e){
			System.out.println("Oops! Unable to register!");
		}
	}


	public boolean isActive() {
		return isActiveUser;
	}

}
