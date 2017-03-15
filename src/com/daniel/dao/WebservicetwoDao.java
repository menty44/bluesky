package com.daniel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daniel.model.Webservicetwo;
import com.daniel.util.HibernateUtil;

public class WebservicetwoDao {

    public void addWebservice(Webservicetwo webservicetwo) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(webservicetwo);
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

    public void deleteWebservicetwo(int employeeid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Webservicetwo webservicetwo = (Webservicetwo) session.load(Webservicetwo.class, new Integer(employeeid));
            session.delete(webservicetwo);
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

    public void updateWebservicetwo(Webservicetwo webservicetwo) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(webservicetwo);
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

    public List<Webservicetwo> getAllWebservicetwoDB() {
        List<Webservicetwo> webservicestwo = new ArrayList<Webservicetwo>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            webservicestwo = session.createQuery("from Webservicetwo").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return webservicestwo;
    }

    public Webservicetwo getWebservicetwoById(int employeeid) {
    	Webservicetwo webservicetwo = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Webservicetwo where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", employeeid);
            webservicetwo = (Webservicetwo) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return webservicetwo;
    }
    
    
    
    public List<Webservicetwo> getListOfWebservicetwo(String searchName){
    	List<Webservicetwo> list = new ArrayList<Webservicetwo>();
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	//Session session = sessFact.openSession();
    	tx = session.beginTransaction();
    	try {
    	tx = session.getTransaction();
    	tx.begin();
    	
    	System.out.println("getListOfWebservice(String searchName) method-"+searchName);
    	list = session.createQuery("from Webservicetwo where name like'"+searchName+"%'").list();
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