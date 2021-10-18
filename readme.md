# Welcome to Rohith CMS!

# Running Instructions:

1.) After running the project, you should see the welcome banner as shown below

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/NotLoggedin.PNG?raw=true)

2.) Use the *login* command to enter into the CMS.

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/LoggedIn.PNG?raw=true)

3.) Use the *articles* command to enter into articles location in CMS. This command should show you the commands for 4 crud operations.

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/Articles.PNG?raw=true)


4.) Use the *list* command to show the list of articles available in CMS.

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/ListArticles.PNG?raw=true)

5.) Use the *new* command to create new article

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/NewArticle.PNG?raw=true)

6.) Use the *delete* command to delete existing article

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/DeleteArticle.PNG?raw=true)

7.) Use the *edit* command to edit/update an existing article

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/EditArticle.PNG?raw=true)

8.) Use the *logoff* command to sign out of the current user "session".

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/Logoff.PNG?raw=true)

9.) Use the *exit* command to quit CMS. 

![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/Exit.PNG?raw=true)



# Project File Structure
The project contains 5 packages as listed below:

 - *com.rohit.cms.articles* 
		 - contains articles related logic
 - *com.rohit.cms.main*
		 - contains entry point and classes that allow cms to run
 - *com.rohit.cms.models*
		 - contains pojo classes and interfaces
 - *com.rohit.cms.tests*
		 - contains unit tests for the project
 - *com.rohit.cms.user*
		 - contains user related logic like login/logoff commands and usersService

# Design Patterns
There are 4 design patterns in the code base. The following section describes the patterns, related files and UML diagram of the pattern.

## Command pattern

###	Files & Packages:
| File	| Package	|
|-----------------|-----------------------|
| CmsCommand.java	|	com.rohit.cms.models	|
| CmsCommandInvoker.java	|	com.rohit.cms.main	|
| EditArticleCommand.java	|	com.rohit.cms.articles	|
| DeleteArticleCommand.java	|	com.rohit.cms.articles	|
| ListArticlesCommand.java	|	com.rohit.cms.articles	|
| NewArticleCommand.java	|	com.rohit.cms.articles	|
| ArticlesService.java	|	com.rohit.cms.articles	|
| LoginCommand.java	|	com.rohit.cms.user	|
| LogoffCommand.java	|	com.rohit.cms.user	|
| UserService.java	|	com.rohit.cms.user	|

### UML  Diagram:
![enter image description here](https://github.com/Rohith191/FinalProject/blob/main/docs/CommandPattern.png?raw=true)

## Builder Pattern

###	Files & Packages:
| File	| Package	|
|-----------------|-----------------------|
| ArticleBuilder.java | com.rohit.cms.articles |
| FreeArticleBuilder.java | com.rohit.cms.articles |
| PremiumArticleBuilder.java | com.rohit.cms.articles |


### UML Diagram:
![enter image description here](https://raw.githubusercontent.com/Rohith191/FinalProject/main/docs/BuilderPattern.png?raw=true)

## Factory Pattern

###	Files & Packages:
| File	| Package	|
|-----------------|-----------------------|
| Validator.java | com.rohit.cms.models |
| ArticleValidator.java | com.rohit.cms.articles |
| UserValidator.java | com.rohit.cms.user |
| ValidatorFactory.java | com.rohit.cms.main |

###	UML Diagram:
![enter image description here](https://raw.githubusercontent.com/Rohith191/FinalProject/main/docs/FactoryPattern.png?raw=true)

## Observer Pattern

###	Files & Packages:
| File	| Package	|
|-----------------|-----------------------|
| CmsObserverSubject.java | com.rohit.cms.models |
| CmsObserver.java | com.rohit.cms.models |
| CmsLocationObserver.java | com.rohit.cms.models |
| UserService.java | com.rohit.cms.user |
| ArticlesService.java | com.rohit.cms.articles |

###	UML Diagram:
![enter image description here](https://raw.githubusercontent.com/Rohith191/FinalProject/main/docs/ObserverPattern.png?raw=true)
