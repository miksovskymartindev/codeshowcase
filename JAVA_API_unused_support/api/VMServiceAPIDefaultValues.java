package de.usu.test.web.api.apitest;

public interface VMServiceAPIDefaultValues {
	
	public abstract class HeaderProps {
		
		/**
		 * represents "application/json"
		 */
		public static final String ACCEPT = "application/json";
		public static final String USER_AGENT = "";
		/**
		 * represents "application/json"
		 */
		public static final String CONTENT_TYPE = "application/json";
		public static final String HOST = "";
	}
	
	/**
	 * represents 'root\' (System.getProperty("user.dir")+"\\") 
	 */
	public static final String ROOT_FOLDER = System.getProperty("user.dir")+"\\";
}
