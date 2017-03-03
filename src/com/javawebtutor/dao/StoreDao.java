package com.javawebtutor.dao;

import java.util.List;
import com.javawebtutor.model.Store;;
 
 
 
/**
 *
 * @author Vikram
 */
public interface StoreDao {
    
    public void saveStore (Store store);
    public List<Store> showAllStore();
    public void updateStore (int id, String name, String phoneno, String email, String branch, String location, String vatno, String krapin);
    public void deleteStore (Store store);
    
    
}