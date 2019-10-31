package de.usu.test.web.core.apitest;
import de.usu.test.web.api.apitest.*;

public class VMServiceAPIRequestHeader implements VMServiceAPIRequestHeaderInterface{

	private String contentTypeProp;
	private String userAgentProp;
	private String acceptProp;
	private String hostNameProp;
	
	@Override
	public void setContentTypeRequestHeaderProperty(String contentType) {
		contentTypeProp = contentType;
	}

	@Override
	public void setUserAgentRequestHeaderProperty(String userAgent) {
		userAgentProp = userAgent;
	}

	@Override
	public void setAcceptRequestHeaderProperty(String acceptRequestHeaderProp) {
		acceptProp = acceptRequestHeaderProp;
	}

	@Override
	public String getContentTypeRequestHeaderProperty() {
		return contentTypeProp == null ? VMServiceAPIDefaultValues.HeaderProps.CONTENT_TYPE : contentTypeProp;
	}

	@Override
	public String getUserAgentRequestHeaderProperty() {
		return userAgentProp == null ? VMServiceAPIDefaultValues.HeaderProps.USER_AGENT : userAgentProp;
	}

	@Override
	public String getAcceptRequestHeaderProperty() {
		return acceptProp == null ? VMServiceAPIDefaultValues.HeaderProps.ACCEPT : acceptProp;
	}

	@Override
	public void setHostRequestHeaderProperty(String hostName) {
		hostNameProp = hostName;
	}

	@Override
	public String getHostRequestHeaderProperty() {
		return hostNameProp == null ? VMServiceAPIDefaultValues.HeaderProps.HOST : hostNameProp;
	}


}
