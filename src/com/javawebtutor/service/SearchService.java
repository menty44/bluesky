package com.javawebtutor.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.User;

public class SearchService {
	
	public List<User> getListOfUsers(String searchName){
		List<User> list = new ArrayList<User>();
		//SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
		 Session session = HibernateUtil.openSession();

		Transaction tx = null;
		//Session session = sessFact.openSession();
		tx = session.beginTransaction();
		try {
		tx = session.getTransaction();
		tx.begin();
		System.out.println("getListOfUsers(String searchName) method-"+searchName);
		list = session.createQuery("from User where name like'" +searchName+ "%'").list();
		
		tx.commit();
		} catch (Exception e) {
		if (tx != null) {
		tx.rollback();
		}
		e.printStackTrace();
		} finally {
		session.close();
		}
		return list;
		}
	
	public List<User> getListOfUsers(){
		List<User> list = new ArrayList<User>();
		//SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
		Transaction tx = null;
		 Session session = HibernateUtil.openSession();
		tx = session.beginTransaction();
		try {
		tx = session.getTransaction();
		tx.begin();
		list = session.createQuery("from users").list();
		tx.commit();
		} catch (Exception e) {
		if (tx != null) {
		tx.rollback();
		}
		e.printStackTrace();
		} finally {
		session.close();
		}
		return list;
		}
	
	

}
