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

import com.daniel.model.Webservice;
import com.daniel.dao.WebserviceDao;



public class WebserviceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebserviceDao dao;
	private SecureRandom random = new SecureRandom();
    
    public WebserviceController(){
        //dao=new WebserviceDao();
    	dao=new WebserviceDao();
    }
    
    public String nextSessionId(){
    	return new BigInteger(130, random).toString(32);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Webservice> webservices=new ArrayList<Webservice>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("getkey")){
				try{						
				//Fetch Data from User Table
				//lstUser=dao.getAllUsers();
					webservices	=dao.getAllWebserviceDB();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(webservices, new TypeToken<List<Webservice>>() {}.getType());
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
				Webservice webservice=new Webservice();
//				if(request.getParameter("webid")!=null){				   
//				   int webid=Integer.parseInt(request.getParameter("webid"));
//				   webservice.setWebid(webid);
//				}
				if(request.getParameter("name")!= null){
				   String name=(String)request.getParameter("name");
				   webservice.setName(name);
				}
				if(request.getParameter("nationalid")!=null){
				   String nationalid=(String)request.getParameter("nationalid");
				   webservice.setNationalid(nationalid);
				}
				if(request.getParameter("mobile")!=null){
					   String mobile=(String)request.getParameter("mobile");
					   webservice.setMobile(mobile);
					}
				if(request.getParameter("hiddenkey")!=null){
					   String hiddenkey=(String)request.getParameter("hiddenkey");
					   webservice.setHiddenkey(hiddenkey);
					}
				try{											
					if(action.equals("create")){//Create new record
						//dao.addStore(store);
						dao.addWebservice(webservice);
						//stores.add(store);
						webservices.add(webservice);
						//Convert Java Object to Json				
						String json=gson.toJson(webservice);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\","
								+ "\"ResponseCode\":\"00\","
								+ "\"Description\":\"Success\","
								+ "\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateWebservice(webservice);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("webid")!=null){
						String id=(String)request.getParameter("webid");
						dao.deleteWebservice(Integer.parseInt(id));
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
