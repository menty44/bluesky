package com.javawebtutor.model;

import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stores")

public class Store implements Serializable {
	
	@Id @GeneratedValue
    private Long id;
    private String name;
    private String phoneno;
    private String email;
    private String branch;
    private String location;
    private String vatno;
    private String krapin;

    public Store() {
    }

    
    public Store(String name, String phoneno, String email, String branch, String location, String vatno, String krapin) {
        
        this.name = name;
        this.email = phoneno;
        this.email = email;
        this.branch = branch;
        this.location = location;
        this.vatno = vatno;
        this.krapin = krapin;    
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getVatno() {
		return vatno;
	}


	public void setVatno(String vatno) {
		this.vatno = vatno;
	}


	public String getKrapin() {
		return krapin;
	}


	public void setKrapin(String krapin) {
		this.krapin = krapin;
	}
    
    
	
	

}
