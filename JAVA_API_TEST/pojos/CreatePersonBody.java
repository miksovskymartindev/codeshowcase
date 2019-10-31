package de.usu.test.web.suite.testcase.interfaces.pojos;

import java.util.List;

public class CreatePersonBody {
	
	private String interfaceActionName 				= PERSON_BODY.interfaceActionName;
	private String Jlastname 						= PERSON_BODY.Jlastname;
	private String Jfirstname	 					= PERSON_BODY.Jfirstname;
	private String Jemail	 						= PERSON_BODY.Jemail;
	private String Jshorttext  						= PERSON_BODY.Jshorttext;
	private String JStatus							= PERSON_BODY.JStatus;
	private String JTitle 	 						= PERSON_BODY.JTitle;
	private String JserviceDomain 	 				= PERSON_BODY.JserviceDomain;
	private CreatePersonBodyDepartment department   = PERSON_BODY.DEPARTMENT_NO;
	private List<CreatePersonBodySystems> Jsystems  = PERSON_BODY.SYSTEMS;
	
	public String getInterfaceActionName() {
		return interfaceActionName;
	}
	
	public void setInterfaceActionName(String interfaceActionName) {
		this.interfaceActionName = interfaceActionName;
	}
	
	public String getJlastname() {
		return Jlastname;
	}
	
	public void setJlastname(String jlastname) {
		Jlastname = jlastname;
	}
	
	public String getJfirstname() {
		return Jfirstname;
	}
	
	public void setJfirstname(String jfirstname) {
		Jfirstname = jfirstname;
	}
	
	public String getJemail() {
		return Jemail;
	}
	
	public void setJemail(String jemail) {
		Jemail = jemail;
	}
	
	public String getJshorttex() {
		return Jshorttext;
	}
	
	public void setJshorttex(String jshorttex) {
		Jshorttext = jshorttex;
	}
	
	public String getJStatus() {
		return JStatus;
	}
	
	public void setJStatus(String jStatus) {
		JStatus = jStatus;
	}
	
	public String getJTitle() {
		return JTitle;
	}
	
	public void setJTitle(String jTitle) {
		JTitle = jTitle;
	}
	
	public String getJserviceDomain() {
		return JserviceDomain;
	}
	
	public void setJserviceDomain(String jserviceDomain) {
		JserviceDomain = jserviceDomain;
	}
	
	public CreatePersonBodyDepartment getDepartment() {
		return department;
	}
	
	public void setDepartment(CreatePersonBodyDepartment department) {
		this.department = department;
	}
	
	public List<CreatePersonBodySystems> getJsystems() {
		return Jsystems;
	}
	
	public void setJsystems(List<CreatePersonBodySystems> jsystems) {
		Jsystems = jsystems;
	}
	


}
