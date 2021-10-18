package com.rohit.cms.articles;

import java.util.List;

import org.davidmoten.text.utils.WordWrap;

import com.rohit.cms.main.CmsUtil;
import com.rohit.cms.main.ValidatorFactory;
import com.rohit.cms.models.Article;
import com.rohit.cms.models.CmsObserver;
import com.rohit.cms.models.CmsObserverSubject;
import com.rohit.cms.models.Validator;
import com.rohit.cms.user.UserService;

public class ArticlesService implements CmsObserverSubject {
	private CmsObserver observer;
	private UserService usersSvc;
	private ArticlesPersistance persistance;
	public ArticlesService(UserService usersSvc, ArticlesPersistance persistance) {
		this.usersSvc = usersSvc;
		this.persistance = persistance;
	}
	
	public void deleteArticle() 
	{
		var id = CmsUtil.askForStringSameLine("Id of the article: ");
		persistance.deleteArticle(Integer.parseInt(id));
		System.out.println("Article deleted!");
	}
	
	public void createNewArticle()
	{
		var title = CmsUtil.askForStringSameLine("Title of article: ");
		var body = CmsUtil.askForStringNewLine("Body of article: ");
		var category = CmsUtil.askForStringSameLine("Category of article: ");
		var is_premium = CmsUtil.askForStringSameLine("Is this a premium article? (Y/N): ").compareToIgnoreCase("y") == 0;
		var tags = CmsUtil.askForStringSameLine("Tags of article (comma separated): ").split(",");
		ValidatorFactory factory = new ValidatorFactory();
		@SuppressWarnings("unchecked")
		Validator<Article> validator = ((Validator<Article>)factory.getValidator(Article.class));
		ArticleBuilder builder;
		if(is_premium) {
			builder = new PremiumArticleBuilder(validator);
		}else {
			builder = new FreeArticleBuilder(validator);	
		}
		try {
			var article = builder
				.addAuthor(usersSvc.getUserName())
				.addCategory(category)
				.addText(body)
				.addTitle(title)
				.addTags(tags)
				.build();
			persistance.addArticle(article);
			
		} catch (Exception e) {
			System.out.println("Unable to create article! ");
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	public void editArticle()
	{
		var id = CmsUtil.askForStringSameLine("Id of the article: ");
		var title = CmsUtil.askForStringSameLine("Title of article: ");
		var body = CmsUtil.askForStringNewLine("Body of article: ");
		var category = CmsUtil.askForStringSameLine("Category of article: ");
		var is_premium = CmsUtil.askForStringSameLine("Is this a premium article? (Y/N): ").compareToIgnoreCase("y") == 0;
		var tags = CmsUtil.askForStringSameLine("Tags of article (comma separated): ").split(",");
		ValidatorFactory factory = new ValidatorFactory();
		@SuppressWarnings("unchecked")
		Validator<Article> validator = ((Validator<Article>)factory.getValidator(Article.class));
		ArticleBuilder builder;
		if(is_premium) {
			builder = new PremiumArticleBuilder(validator);
		}else {
			builder = new FreeArticleBuilder(validator);	
		}
		try {
			var article = builder
				.addAuthor(usersSvc.getUserName())
				.addCategory(category)
				.addText(body)
				.addTitle(title)
				.addTags(tags)
				.build();
			article.id = Integer.parseInt(id);
			persistance.updateArticle(article);
			
		} catch (Exception e) {
			System.out.println("Unable to create article! ");
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	public void displayArticles() {
		List<Article> articles = persistance.getArticles();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		for(var article : articles) {
			System.out.println();
			System.out.println(article.id + ". "+article.title);
			System.out.println();
			String wrapped = WordWrap.from(article.text)
					    .maxWidth(100)
					    .insertHyphens(true)
					    .wrap();
			System.out.println(wrapped);
			System.out.println();
			var t = "Tags: ";
			for(var tag : article.tags) {
				t = t + (tag.trim() + ",");
			}
			System.out.print("Category: "+article.category+" | "+removeTrailingComma(t));
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println();
		}
	}
	String removeTrailingComma(String s) {
	    int index;
	    for (index = s.length() - 1; index > 0; index--) {
	        if (s.charAt(index) != ',') {
	            break;
	        }
	    }
	    return s.substring(0, index + 1);
	}
	String getLocation() {
		return this.observer.getLocation();
	}

	@Override
	public void addObserver(CmsObserver observer) {
		this.observer = observer;	
	}
	
	@Override
	public void notifyObserver(String s) {
		this.observer.setLocation(s);
	}

	public void listArticlesMenu() {
		String menu = "Use any of the following commands to use articles in this cms: \n";
		menu += "'list' to view all articles\n";
		menu += "'edit' to edit an article\n";
		menu += "'new' to create an article\n";
		menu += "'delete' to delete an article\n";
		System.out.println(menu);
		this.notifyObserver("articles");
	}
}
