package com.rohit.cms.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.rohit.cms.articles.ArticleValidator;
import com.rohit.cms.models.Article;

class ArticleValidatorTest {
	@Test
	void ArticleValidator_AddsErrors_If_Text_Is_Empty() {
		var validator = new ArticleValidator();
		assertEquals(false, validator.Validate(new Article()));
		assertEquals(validator.getErrors().size(), 1);
	}
	
	@Test
	void ArticleValidator_AddsErrors_If_Text_Is_MoreThan1000Characters() {
		var validator = new ArticleValidator();
		var t = "";
		for(var i = 0; i < 1001; i++) {
			t = t+ "a";
		}
		var a = new Article();
		a.text = t;
		assertEquals(false, validator.Validate(a));
		assertEquals(validator.getErrors().size(), 1);
	}
	
	@Test
	void ArticleValidator_NoErrors_If_Text_Is_Valid() {
		var validator = new ArticleValidator();
		var a = new Article();
		a.text = "test";
		System.out.println("validator result!"+validator.Validate(a));
		assertEquals(true, validator.Validate(a));
		assertEquals(validator.getErrors().size(), 0);
	}
}
