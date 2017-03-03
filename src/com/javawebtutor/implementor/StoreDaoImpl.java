package com.javawebtutor.implementor;

import java.util.ArrayList;
import java.util.List;
import com.javawebtutor.dao.StoreDao;
import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.Store;
import com.javawebtutor.model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
 
/**
 *
 * @author oluoch
 */
public class StoreDaoImpl implements StoreDao {
 
    @Override
    public void saveStore(Store store) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(store);
        transaction.commit();
        session.close();
    }
 
    @Override
    public List<Store> showAllStore() {
        List<Store> store = new ArrayList();
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery("From stores");
        store = query.list();
        return store;
    }
 
    @Override
    public void updateStore(int id, String name, String phoneno, String email, String branch, String location, String vatno, String krapin) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Store st = (Store)session.load(Store.class, id);
        st.setName(name);;
        st.setPhoneno(phoneno);
        st.setEmail(email);
        st.setBranch(branch);
        st.setBranch(branch);
        st.setLocation(location);
        st.setKrapin(krapin);
        st.setVatno(vatno);
        
        session.update(st);
        transaction.commit();
        session.close();  
    }
 
    @Override
    public void deleteStore(Store store) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(store);
        transaction.commit();
        session.close();
    }
    
//    public User getUserByUserId(String email) {
//        Session session = HibernateUtil.openSession();
//        Transaction tx = null;
//        User user = null;
//        try {
//            tx = session.getTransaction();
//            tx.begin();
//            Query query = session.createQuery("from User where email='"+ email +"'");
//            user = (User)query.uniqueResult();
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            //session.close();
//        }
//        return user;
    
}