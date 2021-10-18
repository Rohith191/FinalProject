package com.rohit.cms.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.rohit.cms.articles.ArticleValidator;
import com.rohit.cms.main.ValidatorFactory;
import com.rohit.cms.models.Article;
import com.rohit.cms.models.CmsUser;
import com.rohit.cms.user.UserValidator;

class ValidatorFactoryTest {
	static ValidatorFactory factory;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		factory = new ValidatorFactory();
	}

	@Test
	void FactoryReturns_UserValidator_If_CmsUser_Is_Passed() {
		var validator = factory.getValidator(CmsUser.class);
		assertEquals(validator.getClass(), UserValidator.class);
	}
	
	@Test
	void FactoryReturns_ArticleValidator_If_Article_Is_Passed() {
		var validator = factory.getValidator(Article.class);
		assertEquals(validator.getClass(), ArticleValidator.class);
	}
	
	@Test
	void FactoryReturns_Null_If_Object_Is_Passed() {
		var validator = factory.getValidator(Object.class);
		assertEquals(null, validator);
	}
}
