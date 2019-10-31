package de.usu.test.web.core.apitest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.usu.test.web.api.apitest.*;

public class VMServiceAPIResponseHandler implements VMServiceAPIResponseInterface {

	private String jsonString;
	private String badResponseErrorMessage;
	private int responseCodeReturned;
	
	/**
	 * Construct Response handler object with json response and response code
	 * @param json - String json response
	 * @param responseCode - int json response code from HttpUrlConnection instance
	 */
	public VMServiceAPIResponseHandler(String json, int responseCode) {
		jsonString = json;
		responseCodeReturned = responseCode;
	}
	
	/**
	 * Construct Response handler for bad request (with response code and error message from HttpUrlConnection instance)
	 * @param responseCode int response code - not 200
	 * @param errorMessage - String error message
	 */
	public VMServiceAPIResponseHandler(int responseCode, String errorMessage) {
		responseCodeReturned = responseCode;
		badResponseErrorMessage = errorMessage;
	}
	
	@Override
	public String getRawString() {
		return responseOK() ? jsonString : badResponseCode();
	}
	
	@Override
	public String getJsonString() {
		return responseOK()? new Gson().toJson(jsonString) : badResponseCode();
	}

	@Override
	public String getPrettyJsonString() {
		if(responseOK()) {
			JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
			return new GsonBuilder().setPrettyPrinting().create().toJson(json);	
		}
		return badResponseCode();
	}

	@Override
	public boolean isTheSameResponseAsExpected(String jsonToBeCompared) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getResponseCode() {
		return responseCodeReturned;
	}
	
	@Override
	public String getResponseErrorMessage() {
		return badResponseErrorMessage == null ? "NaN" : badResponseErrorMessage;
	}
	
	private boolean responseOK() {
		return (responseCodeReturned == 200) ? true : false;
	}
	
	private String badResponseCode() {
		return "Bad request, error code: ["+getResponseCode()+"] "+getResponseErrorMessage();
	}


}
