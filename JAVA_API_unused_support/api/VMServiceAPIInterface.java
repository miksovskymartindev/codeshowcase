package de.usu.test.web.api.apitest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;



public interface VMServiceAPIInterface {

	/**
	 * Method sends request via VMServiceAPI instance
	 * @return true if repsonse status is 200 (OK)
	 * @throws IOException
	 */
	public boolean sendRequest();
	
	/**
	 * Method sends request via VMServiceAPI instance
	 * @param VMServiceAPIRequest instance of request
	 * @return  true if repsonse status is 200 (OK)
	 * @throws IOException
	 */
	public boolean sendRequest(VMServiceAPIRequestInterface jsonRequest) throws IOException;
	
	/**
	 * Method <b> sends HTTP request via VMServiceAPI instance
	 * @param httpRequest - string containing http request
	 * @return true if response status is 200 (OK)
	 */
	
	@Deprecated
	public boolean sendHTTPRequest(String httpRequest);
	/**
	 * <b> NOT READY FOR USE </b>
	 * Method <b> returns handled request from API (VMServiceAPI) instance </b>
	 * @return VMServiceAPIRequestInterface request
	 */
	public VMServiceAPIRequestInterface getRequest();
	
	/**
	 * Method returns response from VMServiceAPI instance
	 * @return VMServiceAPIResponseInterface response
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public VMServiceAPIResponseInterface getResponse();
	
	/**
	 * Method <b> returns current API endpoint url </b>
	 * @return URL API end point
	 */
	public URL getApiEndPointUrl();
	
	/**
	 * Method <b> sets current API endpoint url </b>
	 * @param apiEndPointUrl - url
	 * @throws MalformedURLException
	 */
	public void setApiEndPointUrl(String apiEndPointUrl);
	
	/**
	 * Method <b> sets HTTP request method </b>
	 * @param String request method name
	 */
	public void setRequestMethod(String requestMethod); 
	
	/**
	 * Method <b> returns HTTP request method from Service API instance </b>
	 * @return String request method name
	 */
	public String getRequestMethod();
}
