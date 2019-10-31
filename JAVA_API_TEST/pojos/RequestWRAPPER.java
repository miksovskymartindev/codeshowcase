package de.usu.test.web.suite.testcase.interfaces.pojos;

public class RequestWRAPPER {
	
	private String client 		=	WRAPPER.client;
	private String accessToken 	=	WRAPPER.accessToken;
	private String username 	= 	WRAPPER.username;
	private String password 	= 	WRAPPER.password;
	private String service 		= 	WRAPPER.service;
	private Object params 		= 	WRAPPER.params;
	
	public RequestWRAPPER(String client, String accesToken, String username, String password, String service, Object params) {
		
		setClient(client);
		setAccessToken(accesToken);
		setUsername(username);
		setPassword(password);
		setService(service);
		setParams(params);
	}
	
	public RequestWRAPPER() {
		
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accesToken) {
		this.accessToken = accesToken;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public Object getParams() {
		return params;
	}
	
	public void setParams(Object params) {
		this.params = params;
	}
}

