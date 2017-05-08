package com.daniel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daniel.model.Article;

import com.daniel.util.HibernateUtil;
import com.javawebtutor.model.User;

public class ArticleDao {

    public void addArticle(Article article) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(article);
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

    public void deleteArticle(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Article group = (Article) session.load(Article.class, new Integer(id));
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

    public void updateArticle(Article article) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(article);
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

    public List<Article> getAllArticleDB() {
        List<Article> articles = new ArrayList<Article>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            articles = session.createQuery("from Article").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
            //session.close();
        }
        return articles;
    }

    public Article getArticleById(int userid) {
    	Article article = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Article where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            article = (Article) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
//            session.clear(); 
//            session.disconnect();
            //session.close();
        }
        return article;
    }
    
    public long  getCount() {
        User count1 = new User();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //try {
            trns = session.beginTransaction();
            //count = session.createQuery(" count(*) from User").list();
            long count = (long)session.createQuery("select count(*) from Article").uniqueResult();
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