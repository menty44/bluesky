package com.javawebtutor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
//import com.programmingfree.dao.CrudDao;
//import com.programmingfree.model.User;
import com.daniel.model.Article;
import com.daniel.dao.ArticleDao;



public class ArticleCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao dao;
    
    public ArticleCRUDController() {
        dao=new ArticleDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action")!=null){
			List<Article> articles=new ArrayList<Article>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					articles=dao.getAllArticleDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(articles, new TypeToken<List<Article>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			
			//getting count from the db
			if(action.equals("count")){
				try{						
				//Fetch Data from User Table
				long cnt1 = dao.getCount();
				//String fred = dao.getCount();
					//users=dao.getCount();
				//Convert Java Object to Json				
				//JsonElement element = gson.toJsonTree(users, new TypeToken<List<User>>() {}.getType());
//					JsonElement element = gson.toJsonTree(users, new TypeToken() {
//					});
//				JsonArray jsonArray = element.getAsJsonArray();
//				String listData=jsonArray.toString();	
				String listData= Long.toString(cnt1)  ;
				//Return Json in the format required by jTable plugin
				
				//original json data to be consumed ##freds hack
				//listData="{\"Result\":\"OK\",\"DatabaseCount\":"+listData+"}";
				
				//freds list data hack in order to fetch thr count only..wunt return json response
				listData = listData;
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Article article=new Article();
				if(request.getParameter("article_id")!=null){				   
				   int article_id=Integer.parseInt(request.getParameter("article_id"));
				   article.setArticle_id(article_id);
				}
				if(request.getParameter("title")!=null){
					String title=(String)request.getParameter("title");
					//article.setU(uuid);
					article.setTitle(title);
				}
				if(request.getParameter("category")!=null){
				   String category=(String)request.getParameter("category");
				   article.setCategory(category);
				}
				
				try{											
					if(action.equals("create")){//Create new record
						dao.addArticle(article);					
						articles.add(article);
						//Convert Java Object to Json				
						String json=gson.toJson(article);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateArticle(article);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("article_id")!=null){
						String id=(String)request.getParameter("article_id");
						dao.deleteArticle(Integer.parseInt(id));
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
	 
  }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Article> articles=new ArrayList<Article>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					articles=dao.getAllArticleDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(articles, new TypeToken<List<Article>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Article article=new Article();
				if(request.getParameter("article_id")!=null){				   
					   int article_id=Integer.parseInt(request.getParameter("article_id"));
					   article.setArticle_id(article_id);
					}
					if(request.getParameter("title")!=null){
						String title=(String)request.getParameter("title");
						//article.setU(uuid);
						article.setTitle(title);
					}
					if(request.getParameter("category")!=null){
					   String category=(String)request.getParameter("category");
					   article.setCategory(category);
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addArticle(article);					
						articles.add(article);
						//Convert Java Object to Json				
						String json=gson.toJson(article);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Status\":\"00\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateArticle(article);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Status\":\"01\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("article_id")!=null){
						String id=(String)request.getParameter("article_id");
						dao.deleteArticle(Integer.parseInt(id));
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
	 }
  }
}
