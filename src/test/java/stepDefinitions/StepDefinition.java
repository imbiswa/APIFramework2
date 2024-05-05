package stepDefinitions;
import static io.restassured.RestAssured.given;
import resources.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;

public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given(": Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException{
	    // Write code here that turns the phrase above into concrete actions
		
		
		 
		 
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 res=given().spec(requestSpecification())
		.body(data.addPlacepayLoad(name, language, address));

	    
	}

	@When(": user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		
		response =res.when().post("/maps/api/place/add/json").
				then().spec(resspec).extract().response();

	}

	@Then(": The API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	assertEquals(response.getStatusCode(),200);
	}

	
	@Then(": {string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	    String resp=response.asString();
	    JsonPath js= new JsonPath(resp);
	    assertEquals(js.get(keyValue).toString(),Expectedvalue);
	}
 



}
