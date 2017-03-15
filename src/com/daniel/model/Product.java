package com.daniel.model;

public class Product {
	
	private int prodid;
	private String name;
	private String description;
	private String suggestedunitprice;
	private String buyunitprice;
	private String unitsinstock;
	private String productcode;
	private String uuid;
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
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
	public String getSuggestedunitprice() {
		return suggestedunitprice;
	}
	public void setSuggestedunitprice(String suggestedunitprice) {
		this.suggestedunitprice = suggestedunitprice;
	}
	public String getBuyunitprice() {
		return buyunitprice;
	}
	public void setBuyunitprice(String buyunitprice) {
		this.buyunitprice = buyunitprice;
	}
	public String getUnitsinstock() {
		return unitsinstock;
	}
	public void setUnitsinstock(String unitsinstock) {
		this.unitsinstock = unitsinstock;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
    public String toString() {
        return "Product [prodid=" + prodid + ", name=" + name
                + ", description=" + description + ", suggestedunitprice=" + suggestedunitprice + ", buyunitprice="
                + buyunitprice + ",unitsinstock="
                + unitsinstock + ",productcode="
                + productcode + ",uuid="
                + uuid + ",buyunitprice=" + "]";
    } 
	
	
	

}
