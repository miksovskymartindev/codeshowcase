package de.usu.test.web.core.apitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.usu.test.web.api.apitest.*;

public class VMServiceAPI implements VMServiceAPIInterface{

	VMServiceAPIRequestInterface handledRequest;
	private HttpURLConnection httpUrlConnection;
	private URL apiEndPointUrl;
	private String reqMethod = "POST"; //TODO delet dis?
	
	public VMServiceAPI(String serviceApiEndPointUrl, VMServiceAPIRequestInterface jsonRequest) {
		
		handledRequest = jsonRequest;
		setApiEndPointUrl(serviceApiEndPointUrl);
		
		try {
			
			httpUrlConnection = (HttpURLConnection) getApiEndPointUrl().openConnection();
			httpUrlConnection.setRequestMethod(getRequestMethod());		
			
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		httpUrlConnection.setDoOutput(true);
		httpUrlConnection.setRequestProperty("Accept", jsonRequest.getRequestHeader().getAcceptRequestHeaderProperty());
		httpUrlConnection.setRequestProperty("Content-Type", jsonRequest.getRequestHeader().getContentTypeRequestHeaderProperty());
	}
		
	@Override
	public boolean sendRequest()  {
		return sendRequest(handledRequest);      
	}

	@Override
	public boolean sendRequest(VMServiceAPIRequestInterface jsonRequest)  {
		try(OutputStream os = httpUrlConnection.getOutputStream()) {
		    byte[] input = jsonRequest.getRequestBody().getBytes("utf-8");
		    os.write(input, 0, input.length);  
		    os.close();
		    return isResponseCodeOK();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}

	@Override
	public VMServiceAPIResponseInterface getResponse(){
		
		try {
			if(!isResponseCodeOK()) {
				return new VMServiceAPIResponseHandler(httpUrlConnection.getResponseCode(), httpUrlConnection.getResponseMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(
			new InputStreamReader(httpUrlConnection.getInputStream()))) {
					
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				
				while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
				}
				
				return new VMServiceAPIResponseHandler(response.toString(), httpUrlConnection.getResponseCode());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public void setApiEndPointUrl(String apiEndPoint) {
		try {
			apiEndPointUrl = new URL(apiEndPoint);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public URL getApiEndPointUrl() {
		return apiEndPointUrl;
	}

	@Override
	public VMServiceAPIRequestInterface getRequest() {
		return handledRequest;
	}
	@Override
	public void setRequestMethod(String requestMethod) {
		reqMethod = requestMethod; 		
	}

	@Override
	public String getRequestMethod() {
		return reqMethod;
	}
	
	@Deprecated
	@Override
	public boolean sendHTTPRequest(String httpRequest) {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean isResponseCodeOK() throws IOException {
		return httpUrlConnection.getResponseCode()==200 ? true : false;
	}




}
