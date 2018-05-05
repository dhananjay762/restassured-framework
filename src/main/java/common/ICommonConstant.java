package common;

import io.restassured.http.ContentType;

public interface ICommonConstant {
	
	//RestAssured Configuration
	ContentType CONTENT_TYPE = ContentType.JSON;
	String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";
	String CUSTOMER_REGISTER_TOOLSQA = "http://restapi.demoqa.com/customer/register";
	
	String POST_SAMPLE_FILE = "./postBodySample/";
	
	//Report Configuration
	String CONFIG_PROPERTY_FILE = "./config/config.properties";
	String REPORT_CONFIG_PROPERTY = "reportConfigPath";
	String AUTHOR_NAME = "Dhananjay Dewangan";
	String USER_NAME = System.getProperty("user.name");
	String TIME_ZONE = System.getProperty("user.timezone");
	String MACHINE = "Windows 10 " + "64 Bit";
	String JAVA_VERSION = System.getProperty("java.version");

}
