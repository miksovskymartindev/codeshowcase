package de.usu.test.web.api.apitest;

public interface VMServiceAPIRequestHeaderInterface {

	/**
	 * Method <b> sets value for request header property "Host" </b>
	 * @param String hostName
	 */
	public void setHostRequestHeaderProperty(String hostName);
	
	/**
	 * Method <b> sets value for request header property "Content-Type" </b>
	 * (determines media type of the resource)
	 * @param String - content type
	 */
	public void setContentTypeRequestHeaderProperty(String contentType);
	
	/**
	 * Method <b> sets value for request header property "User-Agent" </b>
	 * (string for identifying application type, OS, software version)
	 * @param String hostName
	 */
	public void setUserAgentRequestHeaderProperty(String userAgentString);
	
	/**
	 * Method <b> sets value for request header property "Accept" </b>
	 * (which data can be sent from server as response)
	 * @param String hostName
	 */
	public void setAcceptRequestHeaderProperty(String acceptRequestHeaderProp);

	/**
	 * Method <b> returns value of request header property "Host" </b>
	 * @return String - value of "Host" property
	 */
	public String getHostRequestHeaderProperty();
	
	/**
	 * Method <b> returns value of request header property "Content-Type" </b>
	 * @return String - value of "Content-Type" property
	 */
	public String getContentTypeRequestHeaderProperty();
	
	/**
	 * Method <b> returns value of request header property "User-Agent" </b>
	 * @return String - value of "User-Agent" property
	 */
	public String getUserAgentRequestHeaderProperty(); 
	
	/**
	 * Method <b> returns value of request header property "Accept" </b>
	 * @return String - value of "Accept" property
	 */
	public String getAcceptRequestHeaderProperty();
}
