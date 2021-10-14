package com.rohit.cms.main;

public class CmsStateObserver implements CmsObserver {

	public CmsStateObserver()
	{
		this.state = "not_logged_in";
	}
	private String state;
	
	@Override
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String getState() {
		return this.state;
	}
}
