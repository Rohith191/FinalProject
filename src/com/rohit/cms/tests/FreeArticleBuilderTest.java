package com.rohit.cms.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.rohit.cms.articles.FreeArticleBuilder;
import com.rohit.cms.main.ValidatorFactory;
import com.rohit.cms.models.Article;
import com.rohit.cms.models.Validator;

class FreeArticleBuilderTest {
	static FreeArticleBuilder builder;
	
	@SuppressWarnings("unchecked")
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ValidatorFactory factory = new ValidatorFactory();
		Validator<Article> validator = ((Validator<Article>)factory.getValidator(Article.class));
		builder = new FreeArticleBuilder(validator);
	}

	@Test
	void testAddTitle() throws Exception {
		var article = builder
				.addTitle("test")
				.addText("text12345")
				.build();
		
		assertEquals(article.title, "test");
	}

	@Test
	void testAddText() throws Exception {
		var article = builder
				.addText("text12345")
				.build();
		
		assertEquals(article.text, "text12345");
	}
	
	@Test
	void testAddCategory() throws Exception {
		var article = builder
				.addText("text12345")
				.addCategory("cat1")
				.build();
		
		assertEquals(article.category, "cat1");
	}

	@Test
	void testAddAuthor() throws Exception {
		var article = builder
				.addText("text12345")
				.addAuthor("author1")
				.build();
		
		assertEquals(article.author, "author1");
	}

	@Test
	void testAddTags() throws Exception {
		var article = builder
				.addText("text12345")
				.addTags(new String[] {"tag1", "tag1"})
				.build();
		
		assertEquals(article.tags.length, 2);//new String[] {"tag1", "tag1"});
	}

	@Test
	void testBuild() throws Exception {
		var article = builder
				.addTitle("test")
				.addText("text12345")
				.build();
		
		assertNotNull(article);
	}

}
