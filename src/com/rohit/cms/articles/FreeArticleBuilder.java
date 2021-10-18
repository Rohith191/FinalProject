package com.rohit.cms.articles;

import com.rohit.cms.models.*;

public class FreeArticleBuilder extends ArticleBuilder{
	
	public FreeArticleBuilder(Validator<Article> articleValidator)  
	{
		super(articleValidator);	
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
	public ArticleBuilder addTags(String[] tags) {
		article.tags = tags;
		return this;
	}
	
//	@Override
//	public ArticleBuilder addTag(String tag) {
//		if(null == tag || "" == tag) {
//			
//		}else {
//			if(article.tags == null) {
//				article.tags = new String[1];
//				article.tags[0] = tag;
//			}else {
//				var list = new ArrayList<String>(Arrays.asList(article.tags));
//				list.add(tag);
//				article.tags = getStringArray(list);
//			}
//		}
//		return this;
//	}

	@Override
	public ArticleBuilder addAuthor(String author) {
		article.author = author;
		return this;
	}

}
