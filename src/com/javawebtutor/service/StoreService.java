package com.javawebtutor.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.Store;

public class StoreService {
	
public boolean save(Store store){
	 Session session = HibernateUtil.openSession();
	 if(isStoreExists(store)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(store);		
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 //session.close();
	 }	
	 return true;
}

public boolean isStoreExists(Store store){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from User where userId='"+store.getEmail()+"'");
		 Store s = (Store)query.uniqueResult();
		 tx.commit();
		 if(s!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 //session.close();
	 }
	 return result;
}

public boolean Count(Store store){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query count = session.createQuery("select count(*) from User");
		 Store s = (Store)count.uniqueResult();
		 //tx.commit();
		 //if(s!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 //session.close();
	 }
	 return result;
}
}