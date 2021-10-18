package com.rohit.cms.main;

import com.rohit.cms.articles.ArticleValidator;
import com.rohit.cms.models.Article;
import com.rohit.cms.models.CmsUser;
import com.rohit.cms.models.Validator;
import com.rohit.cms.user.UserValidator;

public class ValidatorFactory {
	UserValidator userValidator;
	ArticleValidator articleValidator;
	public ValidatorFactory() {
		userValidator = new UserValidator();
		articleValidator = new ArticleValidator();
	}
	public Validator<?> getValidator(Class<?> class1) {
		if(class1.equals(CmsUser.class)) {
			return userValidator;	
		}
		if(class1.equals(Article.class)) {
			return articleValidator;	
		}
		return null;
	}
}
