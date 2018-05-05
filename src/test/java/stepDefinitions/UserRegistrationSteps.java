package stepDefinitions;

import common.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class UserRegistrationSteps extends Utility{
	
	@Given("Form parameter is set for post call")
	public void form_param_is_set(){
		restAssuredPostConfig();
	}
	
	@When("Create user with all details in (.*) file")
	public void create_user(String filename) throws Exception{
		createJsonObject(POST_SAMPLE_FILE+filename);
	}
	
	@When("Make a post call")
	public void make_post_call(){
		restAssuredPostCall(CUSTOMER_REGISTER_TOOLSQA);
	}

}
