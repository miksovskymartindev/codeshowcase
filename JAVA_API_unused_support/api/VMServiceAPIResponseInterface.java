package de.usu.test.web.api.apitest;

public interface VMServiceAPIResponseInterface {
	
	/**
	 * Method gets a <b> response </b> as <b> raw JSON String </b> from VMServiceAPIResponse instance
	 * @return String containing raw JSON response string
	 */
	public String getRawString();
	
	/**
	 * Method gets a <b> response </b> as <b> JSON String </b> from VMServiceAPIResponse instance
	 * @return String containing JSON response string
	 */
	public String getJsonString();
	
	/**
	 * Method gets a <b> response </b> as <b> prettied JSON String </b> from VMServiceAPIResponse instance
	 * @return String containing prettied JSON response string
	 */
	public String getPrettyJsonString();
	
	/**
	 * Method returns <b> response code </b> from VMServiceAPIResponse instance. 
	 * Response code should be sent to constructor from HttpUrlConnection instance for a response error handling cases
	 * @return Integer contains response code take from HttpUrlConnection instance
	 */
	public int getResponseCode();
	
	/**
	 * Method <b> compares two JSON files and returns true if they equals </b>.
	 * @param jsonToBeCompared json which should be compared to json response in this instance
	 * @return boolean isSameResponseAsExpected
	 */
	public boolean isTheSameResponseAsExpected(String jsonToBeCompared); //TODO not implemented, remove white chars
	
	/**
	 * Method returns <b> response error message </b> from VMServiceAPIResponse instance. 
	 * Response message should be sent to constructor from HttpUrlConnection instance for a response error handling cases
	 * @return String contains response code take from HttpUrlConnection instance
	 */
	public String getResponseErrorMessage();
}
