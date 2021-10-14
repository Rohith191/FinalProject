package com.rohit.cms.models;

import com.rohit.cms.main.CmsObserver;

public interface CmsObserverSubject {
	public void addObserver(CmsObserver observer);
	public void notifyObserver(String s);
}
