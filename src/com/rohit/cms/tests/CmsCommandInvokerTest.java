package com.rohit.cms.tests;

import static org.junit.jupiter.api.Assertions.*;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rohit.cms.articles.ArticlesPersistance;
import com.rohit.cms.articles.ArticlesService;
import com.rohit.cms.articles.JsonArticlesPersistance;
import com.rohit.cms.main.CmsCommandInvoker;
import com.rohit.cms.user.UserService;

class CmsCommandInvokerTest {
	static UserService userService;
	static ArticlesPersistance persistance;
	static ArticlesService articleService;
	static CmsCommandInvoker executor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		userService = new UserService();
		persistance = JsonArticlesPersistance.getInstance();
		articleService = new ArticlesService(userService, persistance);
		executor = new CmsCommandInvoker(userService, articleService);
	}

//	private final PrintStream standardOut = System.out;
//	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		// System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void validate_location_login_command_with_not_logged_in_location_should_return_true() {
		var is_valid = executor.validateLocation("login", "not_logged_in");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_login_command_with_logged_in_location_should_return_false() {
		var is_valid = executor.validateLocation("login", "logged_in");
		assertFalse(is_valid);
	}

	@Test
	void validate_location_login_command_with_articles_location_should_return_false() {
		var is_valid = executor.validateLocation("login", "articles");
		assertFalse(is_valid);
	}

	@Test
	void validate_location_logoff_command_with_not_logged_in_location_should_return_false() {
		var is_valid = executor.validateLocation("logoff", "not_logged_in");
		assertFalse(is_valid);
	}

	@Test
	void validate_location_logoff_command_with_logged_in_location_should_return_true() {
		var is_valid = executor.validateLocation("logoff", "logged_in");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_articles_command_with_not_logged_in_location_should_return_true() {
		var is_valid = executor.validateLocation("articles", "not_logged_in");
		assertFalse(is_valid);
	}

	@Test
	void validate_location_articles_command_with_logged_in_location_should_return_true() {
		var is_valid = executor.validateLocation("articles", "logged_in");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_list_command_with_logged_in_location_should_return_true() {
		var is_valid = executor.validateLocation("list", "logged_in");
		assertFalse(is_valid);
	}

	@Test
	void validate_location_list_command_with_articles_location_should_return_true() {
		var is_valid = executor.validateLocation("list", "articles");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_edit_command_with_articles_location_should_return_true() {
		var is_valid = executor.validateLocation("edit", "articles");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_new_command_with_articles_location_should_return_true() {
		var is_valid = executor.validateLocation("new", "articles");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_delete_command_with_articles_location_should_return_true() {
		var is_valid = executor.validateLocation("delete", "articles");
		assertTrue(is_valid);
	}

	@Test
	void validate_location_random_command_with_any_location_should_return_true() {
		var is_valid = executor.validateLocation("abcd", "articles");
		assertFalse(is_valid);
	}
}
