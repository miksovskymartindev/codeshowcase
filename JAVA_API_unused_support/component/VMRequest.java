package de.usu.test.web.core.apitest;

import de.usu.test.web.api.apitest.VMServiceAPIDefaultValues;
import de.usu.test.web.api.apitest.VMServiceAPIFileInterface;
import de.usu.test.web.api.apitest.VMServiceAPIInterface;
import de.usu.test.web.api.apitest.VMServiceAPIRequestHeaderInterface;
import de.usu.test.web.api.apitest.VMServiceAPIRequestInterface;


public class VMRequest {

	private VMServiceAPIInterface api;
	
	/**
	 * Construct <b> request object </b> with specified end point url where JSON request shall be sent
	 * <b> For example : </b> http://127.0.0.1/vmweb/services/api/execwf 
	 * @param endPointUrl
	 */
	public VMRequest(String endPointUrl) {
		api = new VMServiceAPI(endPointUrl, new VMServiceAPIRequest(new VMServiceAPIRequestHeader()));
		getRequestHeader().setContentTypeRequestHeaderProperty(VMServiceAPIDefaultValues.HeaderProps.CONTENT_TYPE);
		getRequestHeader().setAcceptRequestHeaderProperty(VMServiceAPIDefaultValues.HeaderProps.ACCEPT);
	}
	
	
	//TODO specify folder dir for json files, set/hard-code path?
	/**
	 * Load <b> request from file </b> to VMRequest instance
	 * @param fileName path to file
	 */
	public void loadRequestFromFile(String fileName) {
		api.getRequest().setRequestBody(VMServiceAPIFileInterface.loadJsonFileAsString(fileName));
	}
	
	public boolean sendPostRequest(String jsonRequestBody) {
		getRequest().setRequestBody(jsonRequestBody);
		return getApi().sendRequest();
	}
	
	public boolean sendPostRequest() {
		return getApi().sendRequest();
	}
	
	public String getResponse() {
		return getApi().getResponse().getPrettyJsonString();
	}
	
	protected VMServiceAPIInterface getApi() {
		return api;
	}
	
	protected VMServiceAPIRequestInterface getRequest() {
		return api.getRequest();
	}
	
	protected VMServiceAPIRequestHeaderInterface getRequestHeader() {
		return api.getRequest().getRequestHeader();
	}
}
