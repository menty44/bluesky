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

import com.daniel.model.Store;
import com.daniel.dao.StoreDao;



public class StoreCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreDao dao;
    
    public StoreCRUDController() {
        dao=new StoreDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action")!=null){
			List<Store> stores=new ArrayList<Store>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					stores=dao.getAllStoreDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(stores, new TypeToken<List<Store>>() {}.getType());
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
				Store store=new Store();
				if(request.getParameter("userid")!=null){				   
				   int storeid=Integer.parseInt(request.getParameter("storeid"));
				   store.setStoreid(storeid);
				}
				if(request.getParameter("uuid")!=null){
					String uuid=(String)request.getParameter("uuid");
					//group.setU(uuid);
					store.setUuid(uuid);
				}
				if(request.getParameter("name")!=null){
				   String name=(String)request.getParameter("name");
				   store.setName(name);
				}
				if(request.getParameter("phoneno")!=null){
				   String phoneno=(String)request.getParameter("phoneno");
				   store.setPhoneno(phoneno);
				}
				if(request.getParameter("email")!=null){
					   String email=(String)request.getParameter("email");
					   store.setEmail(email);
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addStore(store);					
						stores.add(store);
						//Convert Java Object to Json				
						String json=gson.toJson(store);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateStore(store);
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
						String id=(String)request.getParameter("userid");
						dao.deleteStore(Integer.parseInt(id));
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
			List<Store> stores=new ArrayList<Store>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					stores=dao.getAllStoreDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(stores, new TypeToken<List<Store>>() {}.getType());
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
				Store store=new Store();
				if(request.getParameter("userid")!=null){				   
				   int storeid=Integer.parseInt(request.getParameter("storeid"));
				   store.setStoreid(storeid);
				}
				if(request.getParameter("uuid")!=null){
					String uuid=(String)request.getParameter("uuid");
					//group.setU(uuid);
					store.setUuid(uuid);
				}
				if(request.getParameter("name")!=null){
				   String name=(String)request.getParameter("name");
				   store.setName(name);
				}
				if(request.getParameter("phoneno")!=null){
				   String phoneno=(String)request.getParameter("phoneno");
				   store.setPhoneno(phoneno);
				}
				if(request.getParameter("email")!=null){
					   String email=(String)request.getParameter("email");
					   store.setEmail(email);
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addStore(store);					
						stores.add(store);
						//Convert Java Object to Json				
						String json=gson.toJson(store);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateStore(store);
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
						String id=(String)request.getParameter("userid");
						dao.deleteStore(Integer.parseInt(id));
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
