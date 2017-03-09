package com.daniel.model;

public class Store {
	
	private int storeid;
	private String uuid;
	private String name;
	private String phoneno;
	private String email;
	private String branch;
	private String location;
	private String vatno;
	private String krapin;
	
	
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	
	@Override
    public String toString() {
        return "Store [storeid=" + storeid + ", uuid=" + uuid
                + ", name=" + name + ", phoneno=" + phoneno + ", email="
                + email + ", branch=" + branch + ", location=" + location + ", vatno=" + vatno + ", krapin=" + krapin + "]";
    }  
	

	
}
