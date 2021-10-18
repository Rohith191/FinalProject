package com.rohit.cms.articles;

import java.util.ArrayList;

import com.rohit.cms.models.*;

public abstract class ArticleBuilder {
	Article article;
	String errorText = "Article has validation errors: \n";
	Validator<Article> articleValidator;
	public ArticleBuilder(Validator<Article> articleValidator) {
		this.article = new Article();
		this.articleValidator = articleValidator;
	}
	public abstract ArticleBuilder addTitle(String title);
	public abstract ArticleBuilder addText(String text);
	public abstract ArticleBuilder addCategory(String category);
	public abstract ArticleBuilder addAuthor(String author);
	public abstract ArticleBuilder addTags(String[] tags);
	
	public Article build() throws Exception
	{
		if(articleValidator.Validate(article)) {
			long unixTime = System.currentTimeMillis() / 1000L;
			article.id = unixTime;
			return article;
		}else {
			for(String error : articleValidator.getErrors()) {
				errorText = error + "\n";
			}
			throw new Exception(errorText);
		}
		
	}
	// Function to convert ArrayList<String> to String[]
    public static String[] getStringArray(ArrayList<String> arr)
    {
  
        // declaration and initialise String Array
        String str[] = new String[arr.size()];
  
        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {
  
            // Assign each value to String array
            str[j] = arr.get(j);
        }
  
        return str;
    }
}
