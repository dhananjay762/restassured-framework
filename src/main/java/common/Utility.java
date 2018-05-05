package common;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Utility implements ICommonConstant{
	
	public RequestSpecification requestSpecification;
	public Response response;
	public JsonPath responseJson;
	public String responseStr;
	public ValidatableResponse validatableResponse;
	public Headers headers;
	public JSONObject jsonObject;
	public JSONParser jsonParser;
	public JSONArray jsonArray;
	public SoftAssert softAssert;
	
	public void restAssuredQueryParam(String arg0, String arg1){
		requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification = given().spec(requestSpecification).queryParam(arg0, arg1).relaxedHTTPSValidation("TLS");
	}
	
	public void restAssuredPathParam(String arg0, String arg1){
		requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification = given().spec(requestSpecification).pathParam(arg0, arg1).relaxedHTTPSValidation("TLS");
	}
	
	public void restAssuredFormParam(String arg0, String arg1){
		requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification = given().spec(requestSpecification).accept(ContentType.JSON).formParam(arg0, arg1).relaxedHTTPSValidation("TLS");
	}
	
	public void restAssuredGetConfig(){
		requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification = given().spec(requestSpecification).relaxedHTTPSValidation("TLS");
	}
	
	public void restAssuredPostConfig(){
		requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification = given().spec(requestSpecification).accept(ContentType.JSON).relaxedHTTPSValidation("TLS");
	}
	
	public Response restAssuredGetCall(String endpoint){
		response = requestSpecification.when().get(endpoint);
		return response;
	}
	
	public Response restAssuredPostCall(String endpoint){
		response = requestSpecification.body(this.jsonObject.toJSONString()).when().post(endpoint);
		return response;
	}
	
	public void validateStatusCode(int code){
		response.then().statusCode(code);
	}
	
	public Headers getReponseHeader(){
		headers = response.getHeaders();
		return headers;
	}
	
	public JsonPath getJsonResponse(){
		responseJson = response.jsonPath();
		return responseJson;
	}
	
	public String getPrettyResponse(){
		return response.prettyPrint();
	}
	
	public ValidatableResponse getValidatableResponse(){
		validatableResponse = response.then();
		return validatableResponse;
	}
	
	public String getValueOfResponse(String key){
		return responseJson.get(key);
	}
	
	public void validateResponse(String key, String value){
		response.then().body(key, equalTo(value));
	}
	
	public void checkForResponseIncludes(Map<String, String> responseFields){
		for(Map.Entry<String, String>field: responseFields.entrySet()){
			if(StringUtils.isNumeric(field.getValue())){
				validatableResponse.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}else{
				validatableResponse.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}
	
	public void checkForResponseIncludesInAnyOrder(Map<String, String> responseFields){
		for(Map.Entry<String, String>field: responseFields.entrySet()){
			if(StringUtils.isNumeric(field.getValue())){
				validatableResponse.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}else{
				validatableResponse.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}
	}
	
	public JSONObject createJsonObject(String fileName) throws FileNotFoundException, IOException, ParseException{
		jsonParser = new JSONParser();
//		jsonArray = new JSONArray();
		Object obj = jsonParser.parse(new FileReader(fileName));
		jsonObject = (JSONObject)obj;
		return jsonObject;
	}
	
//	public JSONObject updateJson(JSONObject obj, String keyString, String newValue) throws Exception {
//		Set str = obj.keySet();
//		JSONObject json = new JSONObject();
//	      // get the keys of json object
//	      Set iterator = obj.keySet();
//	      String key = null;
//	      while (((Object) iterator).hasNext()) {
//	          key = (String) iterator.next();
//	          // if the key is a string, then update the value
//	          if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)) {
//	              if ((key.equals(keyString))) {
//	                  // put new value
//	                  obj.put(key, newValue);
//	                  return obj;
//	              }
//	          }
//
//	          // if it's jsonobject
//	          if (obj.optJSONObject(key) != null) {
//	              updateJson(obj.getJSONObject(key), keyString, newValue);
//	          }
//
//	          // if it's jsonarray
//	          if (obj.optJSONArray(key) != null) {
//	              JSONArray jArray = obj.getJSONArray(key);
//	              for (int i = 0; i < jArray.length(); i++) {
//	                  updateJson(jArray.getJSONObject(i), keyString, newValue);
//	              }
//	          }
//	      }
//	      return obj;
//    }
	
	public void setSoftAssert(){
		softAssert = new SoftAssert();
	}
	

}
