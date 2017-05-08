package com.daniel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.daniel.model.User;
import com.javawebtutor.model.User;
import com.daniel.util.HibernateUtil;

public class UserDao {

    public void addUser(User user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
    }

    public void deleteUser(int userid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            User user = (User) session.load(User.class, new Integer(userid));
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
    }

    public void updateUser(User user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
    }

    public List<User> getAllUsersDB() {
        List<User> users = new ArrayList<User>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from User").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
        return users;
    }
    
    public long  getCount() {
        User count1 = new User();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //try {
            trns = session.beginTransaction();
            //count = session.createQuery(" count(*) from User").list();
            long count = (long)session.createQuery("select count(*) from User").uniqueResult();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        finally {
//            session.flush();
//            session.close();
//        }
        //return count;
		return count;
    }

    public User getUserById(int userid) {
        User user = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from User where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
        return user;
    }
    
    
    
    public List<User> getListOfUsers(String searchName){
    	List<User> list = new ArrayList<User>();
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	//Session session = sessFact.openSession();
    	tx = session.beginTransaction();
    	try {
    	tx = session.getTransaction();
    	tx.begin();
    	
    	System.out.println("getListOfUsers(String searchName) method-"+searchName);
    	list = session.createQuery("from User where name like'"+searchName+"%'").list();
    	tx.commit();
    	} catch (Exception e) {
    	if (tx != null) {
    	tx.rollback();
    	}
    	e.printStackTrace();
    	} finally {
//    		session.flush();
//    		session.clear(); 
//            session.disconnect();
    	}
    	return list;
    	}
}