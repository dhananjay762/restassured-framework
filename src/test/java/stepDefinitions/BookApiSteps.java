package stepDefinitions;

import java.util.List;
import java.util.Map;

import bin.Google;
import bin.Item;
import bin.VolumeInfo;
import common.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.mapper.ObjectMapperType;

public class BookApiSteps extends Utility{
	
	public Google google;

	@Given("A book exists with an isbn of (.*)")
	public void a_book_exists_with_isbn(String isbn){
		restAssuredQueryParam("q", "isbn:"+isbn);
	}
	
	@Given("Books exist with author name as \"([^\"]*)\"")
	public void book_exist_with_author_name(String authorName){
		restAssuredQueryParam("q", "publisher:" +authorName);
	}

	@When("User retrieves the book by isbn")
	public void a_user_retrieves_the_book_by_isbn(){
		restAssuredGetCall(ENDPOINT_GET_BOOK_BY_ISBN);
		getValidatableResponse();
		System.out.println("response: " + getPrettyResponse());
	}
	
	@When("User retrieves the book by author name")
	public void user_retrieves_the_book_by_author_name(){
		restAssuredGetCall(ENDPOINT_GET_BOOK_BY_ISBN);
		getValidatableResponse();
		System.out.println("Response: "+ getPrettyResponse());
		google = response.as(Google.class, ObjectMapperType.GSON);
	}

	@Then("The status code is (\\d+)")
	public void verify_status_code(int statusCode){
		validateStatusCode(statusCode);
	}

	/**
	 * asserts on json fields with single values
	 */
	@And("Response includes the following$")
	public void response_equals(Map<String,String> responseFields){
		checkForResponseIncludes(responseFields);
	}
	
	
	/**
	 * asserts on json arrays
	 */
	@And("Response includes the following in any order")
	public void response_contains_in_any_order(Map<String,String> responseFields){
		checkForResponseIncludesInAnyOrder(responseFields);
	}
	
	@Then("Verify that book id is not blank")
	public void verify_that_book_is_not_blank(){
		setSoftAssert();
		List<Item> items = google.getItems();
		for(Item item: items){
			softAssert.assertTrue(!item.getId().equalsIgnoreCase(""), "Id is blank...");
		}
		softAssert.assertAll();
	}
	
	@Then("Verify that book title is not blank")
	public void verify_that_book_title_is_not_blank(){
		List<Item> items = google.getItems();
		for(Item item: items){
			VolumeInfo volumeIfo = item.getVolumeInfo();
			softAssert.assertTrue(!volumeIfo.getTitle().equalsIgnoreCase(""), "Title is blank");
		}
		softAssert.assertAll();
	}

}
