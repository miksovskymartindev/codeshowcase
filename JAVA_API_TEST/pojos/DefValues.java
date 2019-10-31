package de.usu.test.web.suite.testcase.interfaces.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class WRAPPER {
	
	public static final String client = "01";
	public static final String accessToken = "MM239823aaQQ!M1961";
	public static final String username = "-CINTGEN";
	public static final String password = "vm";
	public static final String service = "InterfaceStart";
	public static final Object params =	new CreatePersonBody();
}
	
abstract class TICKET_BODY { 
	
	public static final String personIdReqBy = "Person-13034#";
	public static final String personIdAffected = "Person-13034#";
	public static final String statementtypeId = "Statementtype-102#";
	public static final String ticketclassId = "Ticketclass-200215#";
	public static final String tickettypeId = "Tickettype-202495#";
	public static final String catParentId = "Category-245#";
	public static final String categoryId = "Category-264#";
	public static final String systemId = "";
	public static final String servicesId = "";
	public static final String[] attachments = {};
	public static final String description = "";
	public static final String tckShorttext = "Created at: "+new Date().toString();
	public static final String status = "IN_CRE";
}

abstract class PERSON_BODY {
	
	public static final String interfaceActionName = "VMEx_VM_CreatePerson_Basic";
	public static final String Jlastname = "Some last name";
	public static final String Jfirstname = "Some first name";
	public static final String Jemail = "some@email.com";
	public static final String Jshorttext = "shrtttxt";
	public static final String JStatus= "Locked";
	public static final String JTitle = "Mrs";
	public static final String JserviceDomain = "Automotive";
	public static final CreatePersonBodyDepartment DEPARTMENT_NO = new CreatePersonBodyDepartment("Deer Administration");
	
	@SuppressWarnings("serial")
	public static final List<CreatePersonBodySystems> SYSTEMS = new ArrayList<CreatePersonBodySystems>() {
		{
			add(new CreatePersonBodySystems("USU-0002"));
			add(new CreatePersonBodySystems("USU-0003"));
			add(new CreatePersonBodySystems("USU-0004"));
		}
	};
	
}


