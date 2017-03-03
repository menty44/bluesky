package com.javawebtutor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import javainfinite.DAO.EmployeeDao;
//import javainfinite.DAOImpl.EmployeeDaoImpl;
//import javainfinite.pojo.EmployeeDetails;
import com.javawebtutor.dao.StoreDao;
import com.javawebtutor.implementor.StoreDaoImpl;
import com.javawebtutor.model.Store;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreController extends HttpServlet {

        Store store = new Store();
        StoreDaoImpl sdi = new StoreDaoImpl();
        StoreDao sd;
       
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addStore")!=null){
            String name = request.getParameter("name");
            String phoneno = request.getParameter("phoneno");
            store.setName(name);;
            
            RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
            rd.forward(request, response);
        }
          
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("showStore")!=null){
            List<Store> store = new ArrayList();
            store = sdi.showAllStore();
            request.setAttribute("storeList", store);
            RequestDispatcher rd = request.getRequestDispatcher("showstores.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateStore")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
             String name = request.getParameter("name");
             String phoneno = request.getParameter("phoneno");
             String email = request.getParameter("email");
             String branch = request.getParameter("branch");
             String location = request.getParameter("location");
             String vatno = request.getParameter("vatno");
             String krapin = request.getParameter("krapin");
             sdi.updateStore(id1, name,  phoneno,  email,  branch,  location,  vatno,  krapin);
             
             RequestDispatcher rd = request.getRequestDispatcher("addstores.jsp");
             rd.forward(request, response);
             
         }
          
         if(request.getParameter("deleteStore")!=null){
             long id2 = Integer.parseInt(request.getParameter("id"));
             //sdi.setId(id2);
             store.setId(id2);
             //edi.deleteEmployee(employee);
             sdi.deleteStore(store);
              RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
            rd.forward(request, response);
         }
         
      
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}