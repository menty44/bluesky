package com.daniel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daniel.model.Webservice;
import com.daniel.util.HibernateUtil;

public class WebserviceDao {

    public void addWebservice(Webservice webservice) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(webservice);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteWebservice(int webid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Webservice webservice = (Webservice) session.load(Webservice.class, new Integer(webid));
            session.delete(webservice);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateWebservice(Webservice webservice) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(webservice);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Webservice> getAllWebserviceDB() {
        List<Webservice> webservices = new ArrayList<Webservice>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            webservices = session.createQuery("from Webservice").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return webservices;
    }

    public Webservice getWebserviceById(int webid) {
    	Webservice webservice = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Webservice where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", webid);
            webservice = (Webservice) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return webservice;
    }
    
    
    
    public List<Webservice> getListOfWebservice(String searchName){
    	List<Webservice> list = new ArrayList<Webservice>();
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	//Session session = sessFact.openSession();
    	tx = session.beginTransaction();
    	try {
    	tx = session.getTransaction();
    	tx.begin();
    	
    	System.out.println("getListOfWebservice(String searchName) method-"+searchName);
    	list = session.createQuery("from Webservice where name like'"+searchName+"%'").list();
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