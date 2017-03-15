package com.javawebtutor.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import com.daniel.model.Webservicetwo;
import com.daniel.dao.WebservicetwoDao;



public class WebservicetwoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebservicetwoDao dao;
	private SecureRandom random = new SecureRandom();
    
    public WebservicetwoController(){
        //dao=new WebservicetwoDao();
    	dao=new WebservicetwoDao();
    }
    
    public String nextSessionId(){
    	return new BigInteger(130, random).toString(32);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action")!=null){
			List<Webservicetwo> webservicestwo=new ArrayList<Webservicetwo>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					webservicestwo	=dao.getAllWebservicetwoDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(webservicestwo, new TypeToken<List<Webservicetwo>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();		
				String fred = Long.toString(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
				//Return Json in the format required by jTable plugin
				listData="{\"ResponseCode\":\"00\","
						+ "\"Description\":\"Success\","
						+ "\"HiddenKey\": "+ fred +","
						+ "\"Records\":   "+listData+"}"
						
						;			
				response.getWriter().print(listData);
				
				String content = fred;
				
				//begin
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("rose.txt")))){
					bw.write(content);
					bw.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.toString());
				}
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}	
				
			
			}
			else if(action.equals("create") || action.equals("update")){
				Webservicetwo webservicetwo=new Webservicetwo();
//				if(request.getParameter("employeeid")!=null){				   
//				   int employeeid=Integer.parseInt(request.getParameter("employeeid"));
//				   webservicetwo.setWebid(employeeid);
//				}
				if(request.getParameter("name")!= null){
				   String name=(String)request.getParameter("name");
				   webservicetwo.setName(name);
				}
				if(request.getParameter("email")!=null){
				   String email=(String)request.getParameter("email");
				   webservicetwo.setEmail(email);;
				}
				if(request.getParameter("age")!=null){
					   String age=(String)request.getParameter("age");
					   webservicetwo.setAge(age);
					}
				if(request.getParameter("department")!=null){
					   String department=(String)request.getParameter("department");
					   webservicetwo.setDepartment(department);
					}
				if(request.getParameter("reportingdate")!=null){
					   String reportingdate=(String)request.getParameter("reportingdate");
					   webservicetwo.setReportingdate(reportingdate);
					}
				try{											
					if(action.equals("create")){//Create new record
						//dao.addWebservicetwo(webservicetwo);
						dao.addWebservice(webservicetwo);
						
						webservicestwo.add(webservicetwo);
						//Convert Java Object to Json				
						String json=gson.toJson(webservicetwo);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\","
								+ "\"ResponseCode\":\"00\","
								+ "\"Description\":\"Success\","
								+ "\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateWebservicetwo(webservicetwo);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("employeeid")!=null){
						String id=(String)request.getParameter("employeeid");
						dao.deleteWebservicetwo(Integer.parseInt(id));
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
			List<Webservicetwo> webservicestwo=new ArrayList<Webservicetwo>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					webservicestwo	=dao.getAllWebservicetwoDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(webservicestwo, new TypeToken<List<Webservicetwo>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();		
				String fred = Long.toString(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
				//Return Json in the format required by jTable plugin
				listData="{\"ResponseCode\":\"00\","
						+ "\"Description\":\"Success\","
						+ "\"HiddenKey\": "+ fred +","
						+ "\"Records\":   "+listData+"}"
						
						;			
				response.getWriter().print(listData);
				
				String content = fred;
				
				//begin
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("rose.txt")))){
					bw.write(content);
					bw.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.toString());
				}
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}	
				
			
			}
			else if(action.equals("create") || action.equals("update")){
				Webservicetwo webservicetwo=new Webservicetwo();
//				if(request.getParameter("employeeid")!=null){				   
//				   int employeeid=Integer.parseInt(request.getParameter("employeeid"));
//				   webservicetwo.setWebid(employeeid);
//				}
				if(request.getParameter("name")!= null){
				   String name=(String)request.getParameter("name");
				   webservicetwo.setName(name);
				}
				if(request.getParameter("email")!=null){
				   String email=(String)request.getParameter("email");
				   webservicetwo.setEmail(email);;
				}
				if(request.getParameter("age")!=null){
					   String age=(String)request.getParameter("age");
					   webservicetwo.setAge(age);
					}
				if(request.getParameter("department")!=null){
					   String department=(String)request.getParameter("department");
					   webservicetwo.setDepartment(department);
					}
				if(request.getParameter("reportingdate")!=null){
					   String reportingdate=(String)request.getParameter("reportingdate");
					   webservicetwo.setReportingdate(reportingdate);
					}
				try{											
					if(action.equals("create")){//Create new record
						//dao.addWebservicetwo(webservicetwo);
						dao.addWebservice(webservicetwo);
						
						webservicestwo.add(webservicetwo);
						//Convert Java Object to Json				
						String json=gson.toJson(webservicetwo);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\","
								+ "\"ResponseCode\":\"00\","
								+ "\"Description\":\"Success\","
								+ "\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateWebservicetwo(webservicetwo);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("employeeid")!=null){
						String id=(String)request.getParameter("employeeid");
						dao.deleteWebservicetwo(Integer.parseInt(id));
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
