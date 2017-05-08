package com.daniel.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.daniel.model.Product;
import com.daniel.util.HibernateUtil;
//import com.javawebtutor.model.User;

public class ProductDao {

    public void addProduct(Product product) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(product);
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

    public void deleteProduct(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Product product = (Product) session.load(Product.class, new Integer(id));
            session.delete(product);
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

    public void updateProduct(Product product) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(product);
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

    public List<Product> getAllProductDB() {
        List<Product> products = new ArrayList<Product>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            products = session.createQuery("from Product").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
        return products;
    }

    public Product getProductById(int prodid) {
    	Product product = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Product where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", prodid);
            product = (Product) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
        }
        return product;
    }
    
    public long  getCount() {
        Product count1 = new Product();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //try {
            trns = session.beginTransaction();
            //count = session.createQuery(" count(*) from User").list();
            long count = (long)session.createQuery("select count(*) from Product").uniqueResult();
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