package de.usu.test.web.api.apitest;

import java.io.IOException;


public interface VMServiceAPIRequestInterface {
	
	/**
	 * Method <b> sets request header properties via VMServiceAPIRequestHeader instance </b>
	 * @param requestHeader - instance of VMServiceAPIRequestHeader
	 * @throws IOException
	 */
	public void setRequestHeader(VMServiceAPIRequestHeaderInterface requestHeader) throws IOException;
	
	/**
	 * Method <b> sets request body for request (VMServiceAPIRequest) instance </b>
	 * @param requestBody - json request body
	 */
	public void setRequestBody(String requestBody);
	
	/**
	 * Method <b> returns request body from request (VMServiceAPIRequest) instance </b> as string
	 * @return String - json request body
	 */
	public String getRequestBody();
	
	/**
	 * Method <b> returns request header (VMServiceAPIRequestHeader) instance </b>
	 * @return VMServiceAPIRequestHeaderInterface - request header
	 */
	public VMServiceAPIRequestHeaderInterface getRequestHeader();
}
