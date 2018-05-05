package common;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfiguration implements ICommonConstant{
	
	public RequestSpecification getRequestSpecification(){
		return RestAssured.given().contentType(CONTENT_TYPE);
	}

}
