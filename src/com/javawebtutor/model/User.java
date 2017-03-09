
package com.javawebtutor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
    
    @Id @GeneratedValue
    private Long userid;
    private String unique_id;
    private String name;
    private String email;
    private String phoneno;
    private String idpass;
    private String status;
    private String encrypted_password;
    private String created_at;
    private String updated_at;
    
    
    public String getIdpass() {
		return idpass;
	}


	public void setIdpass(String idpass) {
		this.idpass = idpass;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	

    public User() {
    }

    
    public User(String name, String email, String encrypted_password) {
        //this.unique_id = unique_id;
        this.name = name;
        this.email = email;
        this.encrypted_password = encrypted_password;
        //this.created_at = created_at;
        //this.updated_at = updated_at;
    }


//    public Long getId() {
//        return id;
//    }
//
//     public void setId(Long id) {
//        this.id = id;
//    } 

    public String getUnique_id() {
		return unique_id;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEncrypted_password() {
		return encrypted_password;
	}


	public void setEncrypted_password(String encrypted_password) {
		this.encrypted_password = encrypted_password;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public String getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}


	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

           
}
