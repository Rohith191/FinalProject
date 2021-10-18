package com.rohit.cms.articles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rohit.cms.models.Article;

public class JsonArticlesPersistance implements ArticlesPersistance {
	private static ArticlesPersistance instance;
	private ArrayList<Article> articles;
	
	private JsonArticlesPersistance() {
		load();
	}
	
	public static synchronized ArticlesPersistance getInstance() {
		if (instance == null) {
			instance = new JsonArticlesPersistance();
		}
		return instance;
	}
	
	@Override
	public List<Article> getArticles(){
		articles.sort(new IdComparator());
		return articles;
	}
	
	@Override
	public void addArticle(Article article)
	{
		articles.add(article);
		save();
		System.out.println("Article Saved!");
	}
	
	@Override
	public void deleteArticle(long id)
	{
		articles.removeIf(a -> a.id == id);
		save();
	}
	
	@Override
	public void updateArticle(Article article)
	{
		deleteArticle(article.id);
		addArticle(article);
		save();
	}
	
	private void save() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(articles);
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream("articles.json");
			byte[] strToBytes = jsonString.getBytes();
		    outputStream.write(strToBytes);
		    outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	private void load() {
		File file = new File("articles.json");
		if(!file.exists()) {
			this.articles = new ArrayList<Article>();
			return;
		}
		var gson = new Gson();
		try {
			Type listOfMyClassObject = new TypeToken<ArrayList<Article>>() {}.getType();
			String jsonString = new String(Files.readAllBytes(Paths.get("articles.json")));
			this.articles = gson.fromJson(jsonString, listOfMyClassObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	class IdComparator implements Comparator<Article> {
	    @Override
	    public int compare(Article a, Article b) {
	        return a.id < b.id ? -1 : a.id == b.id ? 0 : 1;
	    }
	}

	@Override
	public int getArticlesCount() {
		if(this.articles == null)
			return 0;
		return this.articles.size();
	}
}
