package com.rohit.cms.articles;

import java.util.ArrayList;
import java.util.Arrays;

import com.rohit.cms.models.*;

public class PremiumArticleBuilder extends ArticleBuilder {

	public PremiumArticleBuilder(Validator<Article> articleValidator) {
		super(articleValidator);
		article.isPremium = true;
	}

	@Override
	public ArticleBuilder addTitle(String title) {
		article.title = "[Premium]" + title;
		return this;
	}

	@Override
	public ArticleBuilder addText(String text) {
		article.text = "(You are reading Premium article!) \n" + text;
		return this;
	}

	@Override
	public ArticleBuilder addCategory(String category) {
		article.category = category;
		return this;
	}

	@Override
	public ArticleBuilder addTags(String[] tags) {
		var list = new ArrayList<String>(Arrays.asList(tags));
		list.add("Premium");
		article.tags = getStringArray(list);
		return this;
	}

//	@Override
//	public ArticleBuilder addTag(String tag) {
//		if(null == tag || "" == tag) {
//			
//		}else {
//			if(article.tags == null) {
//				article.tags = new String[2];
//				article.tags[0] = "Premium";
//				article.tags[1] = tag;
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
