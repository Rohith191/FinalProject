package com.rohit.cms.application;

import java.util.ArrayList;

import com.rohit.cms.models.Article;
import com.rohit.cms.models.CmsUser;

public class FreeArticleBuilder extends ArticleBuilder{
	
	public FreeArticleBuilder(ValidatorFactory factory)  
	{
		super(factory);	
		article = new Article();
	}
	
	@Override
	public ArticleBuilder addTitle(String title) {
		article.title = title;
		return this;
	}

	@Override
	public ArticleBuilder addText(String text) {
		article.text = text;
		return this;
	}

	@Override
	public ArticleBuilder addCategory(String category) {
		article.category = category;
		return this;
	}

	@Override
	public ArticleBuilder addTag(String tag) {
		if(article.tags == null) {
			article.tags = new ArrayList<String>();
		}
		if(null == tag || "" == tag) {
			
		}else {
			article.tags.add(tag);
		}
		return this;
	}

	@Override
	public ArticleBuilder addAuthor(CmsUser author) {
		article.author = author;
		return this;
	}

	@Override
	public ArticleBuilder addEditor(CmsUser editor) {
		article.editor = editor;
		return this;
	}

}
