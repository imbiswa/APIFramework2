package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	
	public void BeforeScenario() throws IOException
	{
		//execute this when place id is null because , it depemds on add place id then only we can delete
		//write a code which will give here the place_id
		
		StepDefinition m = new StepDefinition();
		if(StepDefinition.place_id==null)
		{
		m.add_place_payload_with("mallick", "bbb", "ccc");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("mallick", "getPlaceAPI");
        }
    }
}
