package stepDefinitions;

import org.junit.Assert;

import common.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistrationSteps extends Utility{
	
	@Given("Form parameter is set for post call")
	public void form_param_is_set(){
		restAssuredPostConfig();
	}
	
	@When("Create user with all details in \"([^\"]*)\" file")
	public void create_user(String filename) throws Exception{
		createJsonObject(POST_SAMPLE_FILE+filename);
	}
	
	@When("Make a post call")
	public void make_post_call(){
		restAssuredPostCall(CUSTOMER_REGISTER_TOOLSQA);
		System.out.println("Response Headers: "+getReponseHeader());
		System.out.println("Response body: "+getPrettyResponse());
		System.out.println("Status code: "+getStatusCode());
	}
	
	@Then("Status code should be (\\d+)")
	public void status_code_should_be(int code){
		Assert.assertEquals(code, getStatusCode());
	}
	
	@Then("Validate that user is added successfully")
	public void validate_that_user_is_added_successfully(){
		validateResponse("SuccessCode", "OPERATION_SUCCESS");
	}
	
	@Then("Validate that user already exists")
	public void validate_that_user_already_exists(){
		validateResponse("FaultId", "User already exists");
	}

}
