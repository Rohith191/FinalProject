package com.rohit.cms.application;

import com.rohit.cms.models.Article;
import com.rohit.cms.models.ArticleState;
import com.rohit.cms.models.CmsUser;

public abstract class ArticleBuilder {
	Article article;
	String errorText = "Article has validation errors: \n";
	ValidatorFactory validatorFactory;
	public ArticleBuilder(ValidatorFactory validatorFactory) {
		this.validatorFactory = validatorFactory;
	}
	public abstract ArticleBuilder addTitle(String title);
	public abstract ArticleBuilder addText(String text);
	public abstract ArticleBuilder addCategory(String category);
	public abstract ArticleBuilder addTag(String tag);
	public abstract ArticleBuilder addAuthor(CmsUser author);
	public abstract ArticleBuilder addEditor(CmsUser editor);
	
	public Article build() throws Exception
	{
		article.state = ArticleState.DRAFT;
		article.comment_count = 0;
		var validator = validatorFactory.getValidator("article", article);
		if(validator.Validate()) {
			return article;
		}else {
			for(String error : validator.getErrors()) {
				errorText = error + "\n";
			}
			throw new Exception(errorText);
		}
		
	}
}
