package com.rohit.cms.user;

import com.rohit.cms.main.CmsUtil;
import com.rohit.cms.models.CmsObserver;
import com.rohit.cms.models.CmsObserverSubject;
import com.rohit.cms.models.CmsUser;



public class UserService implements CmsObserverSubject {
	private CmsUser user;
	private CmsObserver observer;
	public UserService() {
		this.user = new CmsUser();
	}
	
	public String getUserName() {
		return this.user.username;
	}
	
	public void loginNewUser() {
		this.user.username = CmsUtil.askForStringSameLine("Enter user name: ");
        this.user.password = CmsUtil.askForStringSameLine("Enter password: ");
		this.user.setActiveUser();
		this.user.greet();
		notifyObserver("logged_in");
	}
	
	public void logoffUser() {
		this.user.setInActive();
		this.user.bidGoodbye();
		notifyObserver("not_logged_in");
	}

	@Override
	public void addObserver(CmsObserver observer) {
		this.observer = observer;	
	}
	
	@Override
	public void notifyObserver(String s) {
		this.observer.setLocation(s);
	}

	public boolean isActive() {
		return this.user.isActive();
	}
}
