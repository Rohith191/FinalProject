package com.rohit.cms.application;
import java.util.ArrayList;

import com.rohit.cms.models.Article;
import com.rohit.cms.models.CmsUser;

public class PremiumArticleBuilder extends ArticleBuilder {

	public PremiumArticleBuilder(ValidatorFactory factory)  
	{
		super(factory);	
	}
	
	@Override
	public ArticleBuilder addTitle(String title) {
		article.title = "[Premium]"+title;
		return this;
	}

	@Override
	public ArticleBuilder addText(String text) {
		article.text = "You are reading Premium article! \n"+ text;
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
			article.tags.add("Premium");
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
	
	public Article build() {
		article.isPremium = true;
		return article;
	}

}
