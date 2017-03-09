package com.daniel.model;

public class Group {
	
	private int userid;
	private String uuid;
	private String name;
	private String description;
	private String createdon;
	
	public int getId() {
		return userid;
	}
	public void setId(int id) {
		this.userid = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	
	@Override
    public String toString() {
        return "Group [userid=" + userid + ", uuid=" + uuid
                + ", name=" + name + ", description=" + description + ", createdon="
                + createdon + "]";
    }  
	
	

}
