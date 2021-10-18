package com.rohit.cms.models;

public class CmsLocationObserver implements CmsObserver {

	public CmsLocationObserver()
	{
		this.location = "not_logged_in";
	}
	private String location;
	
	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String getLocation() {
		return this.location;
	}
}
