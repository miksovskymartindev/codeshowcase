package de.usu.test.web.suite.testcase.interfaces.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.usu.test.web.suite.testcase.interfaces.pojos.CreatePersonBody;
import de.usu.test.web.suite.testcase.interfaces.pojos.CreatePersonBodyDepartment;
import de.usu.test.web.suite.testcase.interfaces.pojos.CreatePersonBodySystems;
import de.usu.test.web.suite.testcase.interfaces.pojos.RequestWRAPPER;

public class CreatePerson {

	private RequestWRAPPER wrapper;
	private CreatePersonBody personBody;
	private CreatePersonBodyDepartment personBodyDepartment;
	private CreatePersonBodySystems personBodySystems;
	private Gson gson;
	private GsonBuilder builder = new GsonBuilder();
	
	public CreatePerson() {
		wrapper = new RequestWRAPPER();
		personBody = new CreatePersonBody();
		personBodyDepartment = new CreatePersonBodyDepartment();
		personBodySystems = new CreatePersonBodySystems();
		gson = builder.create();
	}
	
	public CreatePersonBody onPersonBody() {
		return personBody;
	}
	
	/**
	 * <h1> Wrapper </h1>
	 * method returns a RequestWRAPPER instance which is handling VM API wrapper for incoming requests. Wrapper contains meta settings
	 * and handles basic authentication for using Valuemation web services. In this case we're using Username and Password as an authetication
	 * credentials instead of token option.
	 * Wrapper contains these JSON objects (and getter/setter methods): 
	 * <h3> client </h3> ID of web service client <b> Default value: "01" </b>
	 * <h3> accessToken </h3> web service access token<b> Default value: "MM239823aaQQ!M1961" </b>
	 * <h3> username </h3> web service user name <b> Default value: "-CINTGEN" </b>
	 * <h3> password </h3> object containing body request<b> Default value: "vm" </b>
	 * <h3> service </h3> Valuemation web service name<b> Default value: "InterfaceStart" </b>
	 * <h3> password </h3> Valuemation user password<b> Default value: def val </b>
	 * @return RequestWRAPPER object reference
	 */
	public RequestWRAPPER onWrapper() {
		return wrapper;
	}
	
	public String getCreatePersonJsoned() {
		personBody.setDepartment(personBodyDepartment);
		wrapper.setParams(personBody);
		return gson.toJson(wrapper);
	}

	
	
}
