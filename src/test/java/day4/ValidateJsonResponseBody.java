package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	
	// https://reqres.in/api/users?page=2
	
	@Test
	public void userListResponseBody()
	{
		// Get requestSpecification reference
		RequestSpecification reqSpec = RestAssured.given();
		
		// specify the base uri
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users?page=2");
		reqSpec.header("x-api-key","reqres-free-v1");
		
		// create get request
		Response response = reqSpec.get();
		
		// read response body
		ResponseBody resBody = response.getBody();
		
		// convert response body into string
		String responseBody = resBody.asString();
		
		System.out.println(responseBody);
		
		// validate George is present in response body
		Assert.assertEquals(responseBody.contains("Emma"),true,"Sorry !!Name is not present in the response..");
		
		// Get JSON path view of response body
		
		
		JsonPath jsonpathView = resBody.jsonPath();
		String first_name = jsonpathView.get("data[0].first_name");
		
		System.out.println("First name of json response is :"+first_name);
		
		Assert.assertEquals(first_name, "George","name is not matched with response..");
		
	}

}
