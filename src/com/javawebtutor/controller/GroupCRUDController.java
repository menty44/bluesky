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
import com.daniel.model.Group;
import com.daniel.dao.GroupDao;



public class GroupCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupDao dao;
    
    public GroupCRUDController() {
        dao=new GroupDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action")!=null){
			List<Group> groups=new ArrayList<Group>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					groups=dao.getAllGroupDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(groups, new TypeToken<List<Group>>() {}.getType());
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
				Group group=new Group();
				if(request.getParameter("userid")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("userid"));
				   group.setId(userid);
				}
				if(request.getParameter("uuid")!=null){
					String uuid=(String)request.getParameter("uuid");
					//group.setU(uuid);
					group.setUuid(uuid);
				}
				if(request.getParameter("name")!=null){
				   String name=(String)request.getParameter("name");
				   group.setName(name);
				}
				if(request.getParameter("description")!=null){
				   String description=(String)request.getParameter("description");
				   group.setDescription(description);
				}
				if(request.getParameter("createdon")!=null){
					   String createdon=(String)request.getParameter("createdon");
					   group.setCreatedon(createdon);
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addGroup(group);					
						groups.add(group);
						//Convert Java Object to Json				
						String json=gson.toJson(group);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateGroup(group);
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
						dao.deleteGroup(Integer.parseInt(id));
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
			List<Group> groups=new ArrayList<Group>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					groups=dao.getAllGroupDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(groups, new TypeToken<List<Group>>() {}.getType());
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
				Group group=new Group();
				if(request.getParameter("userid")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("userid"));
				   group.setId(userid);
				}
				if(request.getParameter("uuid")!=null){
					String uuid=(String)request.getParameter("uuid");
					//group.setU(uuid);
					group.setUuid(uuid);
				}
				if(request.getParameter("name")!=null){
				   String name=(String)request.getParameter("name");
				   group.setName(name);
				}
				if(request.getParameter("description")!=null){
				   String description=(String)request.getParameter("description");
				   group.setDescription(description);
				}
				if(request.getParameter("createdon")!=null){
					   String createdon=(String)request.getParameter("createdon");
					   group.setCreatedon(createdon);
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addGroup(group);					
						groups.add(group);
						//Convert Java Object to Json				
						String json=gson.toJson(group);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateGroup(group);
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
						dao.deleteGroup(Integer.parseInt(id));
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
