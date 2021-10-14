package com.rohit.cms.application;

import java.util.ArrayList;
import java.util.List;

import com.rohit.cms.models.Article;
import com.rohit.cms.models.Validator;

public class ArticleValidator implements Validator {
	Article article;
	ArrayList<String> errors;
	public ArticleValidator(Article article) {
		this.article = article;
		this.errors = new ArrayList<String>();
	}
	@Override
	public boolean Validate() {
		if(article.text == null || article.text == "") {
			errors.add("article body cannot be empty!");
		}
		if(article.text != null || article.text.length() > 100) {
			errors.add("article body cannot be greater than 100 characters!");
		}
		return errors.size() == 0;
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}

}
