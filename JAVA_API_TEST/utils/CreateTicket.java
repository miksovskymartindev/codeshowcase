package de.usu.test.web.suite.testcase.interfaces.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.usu.test.web.suite.testcase.interfaces.pojos.CreateTicketBody;
import de.usu.test.web.suite.testcase.interfaces.pojos.RequestWRAPPER;
import io.restassured.RestAssured;


public class CreateTicket {

	private CreateTicketBody ticketBody;
	private RequestWRAPPER wrapper;
	private GsonBuilder builder;
	private Gson gson ;
	
	public CreateTicket() {
		wrapper = new RequestWRAPPER();
		ticketBody = new CreateTicketBody();
		builder = new GsonBuilder().serializeNulls();
		gson = builder.create();
	}
	
	public String getJsonedCreateTicket(){
		wrapper.setParams(ticketBody);
		return new Gson().toJson(wrapper);
	}
	
	/**
	 * <h1> Wrapper </h1>
	 * method returns a RequestWRAPPER instance which is handling VM API wrapper for incoming requests. Wrapper contains meta settings
	 * and handles basic authentication for using Valuemation web services. In this case we're using Username and Password as an authetication
	 * credentials instead of token option.
	 * Wrapper contains these JSON objects (and getter/setter methods): 
	 * <h3> client </h3> no idea
	 * <h3> accessToken </h3> ....
	 * <h3> client </h3> .... 
	 * <h3> params </h3> object containing body request
	 * <h3> username </h3> Valuemation user name
	 * <h3> password </h3> Valuemation user password
	 * @return RequestWRAPPER object reference
	 */
	public RequestWRAPPER onWrapper() {
		return wrapper;
	}
	
	/**
	 * <h1> Create Ticket Request Body </h1>
	 * method returns a CreateTicketBody instance for handling request body POJO for JSON serialization. Instance of this POJO should be wrapped by 
	 * RequestWRAPPER object (sent as parameter to setParams method on WRAPPER object) before serialization.
	 * @return
	 */
	public CreateTicketBody onTicketBody() {
		return ticketBody;
	}
	
	
	

}
