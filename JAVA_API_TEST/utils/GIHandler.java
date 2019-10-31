package de.usu.test.web.suite.testcase.interfaces.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GIHandler {

	private CreatePerson createPerson;
	private CreateTicket createTicket;
	
	public GIHandler() {
		createPerson = new CreatePerson();
		createTicket = new CreateTicket();
	}
	/**
	 * Returns an instance of CreatePerson class
	 * @return
	 */
	public CreatePerson onCreatePerson() {
		return createPerson;
	}
	
	/**
	 * Returns an instance of CreateTicket class
	 * @return
	 */
	public CreateTicket onCreateTicket() {
		return createTicket;
	}
	
	/**
	 * Method sends request and returns a Response object
	 * @param aRequestBody - String JSON request body
	 * @param anEndpoint - String Endpoint of a Valuemation web service
	 * @return
	 */
	public Response sendRequestAndGetResponse(String aRequestBody, String anEndpoint) {
		return RestAssured.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(aRequestBody)
			.post(anEndpoint)
			.andReturn();
	}
}
