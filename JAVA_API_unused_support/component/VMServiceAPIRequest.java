package de.usu.test.web.core.apitest;

import java.io.IOException;
import de.usu.test.web.api.apitest.*;

public class VMServiceAPIRequest implements VMServiceAPIRequestInterface {

	private VMServiceAPIRequestHeader requestHeader;
	private String requestBody;

	public VMServiceAPIRequest(VMServiceAPIRequestHeaderInterface jsonRequestHeader) {
		requestHeader = (VMServiceAPIRequestHeader) jsonRequestHeader;
	}
	
	public VMServiceAPIRequest(VMServiceAPIRequestHeaderInterface jsonRequestHeader, String jsonRequestBody) {
		requestHeader = (VMServiceAPIRequestHeader) jsonRequestHeader;
		requestBody = jsonRequestBody;
	}

	@Override
	public void setRequestHeader(VMServiceAPIRequestHeaderInterface jsonRequestHeader) throws IOException {
		requestHeader = (VMServiceAPIRequestHeader) jsonRequestHeader;
	}

	@Override
	public void setRequestBody(String jsonRequestBody) {
		requestBody = jsonRequestBody;
	}

	@Override
	public String getRequestBody() {
		return requestBody;
	}

	@Override
	public VMServiceAPIRequestHeaderInterface getRequestHeader() {
		return requestHeader == null ? new VMServiceAPIRequestHeader() : requestHeader;
	}

}
