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

//import com.daniel.model.User;
import com.javawebtutor.model.User;
import com.daniel.dao.UserDao;


public class UserCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
    
    public UserCRUDController() {
        dao=new UserDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<User> users=new ArrayList<User>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					users=dao.getAllUsersDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(users, new TypeToken<List<User>>() {}.getType());
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
				User user=new User();
				if(request.getParameter("userid")!=null){				   
				   long userid=Integer.parseInt(request.getParameter("userid"));
				   user.setUserid(userid);
				}
				if(request.getParameter("name")!=null){
					String name=(String)request.getParameter("name");
					user.setName(name);
				}
				if(request.getParameter("status")!=null){
				   String status=(String)request.getParameter("status");
				   user.setStatus(status);
				}
				if(request.getParameter("email")!=null){
				   String email=(String)request.getParameter("email");
				   user.setEmail(email);
				}
				if(request.getParameter("created_at")!=null){
					   String created_at=(String)request.getParameter("created_at");
					   user.setCreated_at(created_at);;
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addUser(user);					
						users.add(user);
						//Convert Java Object to Json				
						String json=gson.toJson(user);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateUser(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("userid")!=null){
						String userid=(String)request.getParameter("userid");
						dao.deleteUser(Integer.parseInt(userid));
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
