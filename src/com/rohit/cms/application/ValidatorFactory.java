package com.rohit.cms.application;

import com.rohit.cms.models.Article;
import com.rohit.cms.models.Comment;
import com.rohit.cms.models.CmsUser;
import com.rohit.cms.models.Validator;
import com.rohit.cms.user.UserValidator;

public class ValidatorFactory {
	public Validator getValidator(String validatorType, Object objToValidate)
	{
		switch(validatorType) {
			case "user":
				return new UserValidator((CmsUser) objToValidate);
			case "comment":
				return new CommentValidator((Comment) objToValidate);
			case "article":
				return new ArticleValidator((Article) objToValidate);
			default:
				return null;
		}
	}
}
