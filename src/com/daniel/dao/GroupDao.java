package com.daniel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daniel.model.Group;
//import com.daniel.model.User;
import com.daniel.util.HibernateUtil;
import com.javawebtutor.model.User;

public class GroupDao {

    public void addGroup(Group group) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(group);
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
            //session.close();
        }
    }

    public void deleteGroup(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Group group = (Group) session.load(Group.class, new Integer(id));
            session.delete(group);
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
            //session.close();
        }
    }

    public void updateGroup(Group group) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(group);
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
            //session.close();
        }
    }

    public List<Group> getAllGroupDB() {
        List<Group> groups = new ArrayList<Group>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            groups = session.createQuery("from Group").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
            //session.close();
        }
        return groups;
    }

    public Group getGroupById(int userid) {
    	Group group = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Group where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            group = (Group) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
            //session.close();
        }
        return group;
    }
    
    public long  getCount() {
        User count1 = new User();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //try {
            trns = session.beginTransaction();
            //count = session.createQuery(" count(*) from User").list();
            long count = (long)session.createQuery("select count(*) from Group").uniqueResult();
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
}