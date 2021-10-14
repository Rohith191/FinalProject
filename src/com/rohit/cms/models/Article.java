package com.rohit.cms.models;

import java.util.List;

public class Article {
	public String text;
	public List<String> tags;
	public CmsUser author;
	public CmsUser editor;
	public String title;
	public int comment_count;
	public ArticleState state;
	public String category;
	public boolean isPremium;
	public int id;
}
