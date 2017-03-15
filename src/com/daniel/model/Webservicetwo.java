package com.daniel.model;

public class Webservicetwo {
	private int employeeid;
	private String name;
	private String email;
	private String age;
	private String department;
	private String reportingdate;
	
	
	public int getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getReportingdate() {
		return reportingdate;
	}


	public void setReportingdate(String reportingdate) {
		this.reportingdate = reportingdate;
	}


	@Override
    public String toString() {
        return "Webservice [employeeid=" + employeeid + ", name=" + name + ", email=" + email + ", age=" + age + ", department="
                + department + ", reportingdate=" + reportingdate + "]";
    }  
	
}
