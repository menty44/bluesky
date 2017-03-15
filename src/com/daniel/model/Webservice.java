package com.daniel.model;

public class Webservice {
	
	private int webid;
	private String name;
	private String nationalid;
	private String mobile;
	private String hiddenkey;
	
	
	public int getWebid() {
		return webid;
	}
	public void setWebid(int webid) {
		this.webid = webid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationalid() {
		return nationalid;
	}
	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHiddenkey() {
		return hiddenkey;
	}
	public void setHiddenkey(String hiddenkey) {
		this.hiddenkey = hiddenkey;
	}
	
	
	@Override
    public String toString() {
        return "Webservice [webid=" + webid + ", name=" + name + ", nationalid=" + nationalid + ", mobile=" + mobile + ", hiddenkey="
                + hiddenkey + "]";
    }  
	

}
