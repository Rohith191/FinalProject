package com.rohit.cms.articles;

import java.util.ArrayList;
import java.util.List;

import com.rohit.cms.models.Article;
import com.rohit.cms.models.Validator;

public class ArticleValidator implements Validator<Article> {
	ArrayList<String> errors;
	public ArticleValidator() {
		this.errors = new ArrayList<String>();
	}
	@Override
	public boolean Validate(Article article) {
		if(article.text == null || article.text == "") {
			errors.add("article body cannot be empty!");
		}
		if(article.text != null && article.text.length() > 1000) {
			errors.add("article body cannot be greater than 1000 characters!");
		}
		return errors.size() == 0;
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}

}
