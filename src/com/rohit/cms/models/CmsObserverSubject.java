package com.rohit.cms.models;

public interface CmsObserverSubject {
	public void addObserver(CmsObserver observer);
	public void notifyObserver(String s);
}
