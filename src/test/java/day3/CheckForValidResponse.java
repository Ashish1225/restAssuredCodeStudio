package day3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	
	//https://reqres.in/api/users/2
	
	// validate response status using Assert
	
	@Test
	public void getSingleUser() {
		
		// specify the url
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		// get request-specification of the request
		
		RequestSpecification reqSpec = RestAssured.given();
		
		// call get method
		
		Response response = reqSpec.get();
		
		
		/// get the status code
		int statusCode = response.getStatusCode();
		
		// validate the status code
		Assert.assertEquals(statusCode, 200,"Status code is not matched with expected..");
		
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","StatusLine not matched with expected..");
	}
	
	
	@Test
	public void getSingleUserUsingValidatableResponse() {
		// specify the url
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		// get request-specification of the request
		
		RequestSpecification reqSpec = RestAssured.given();
		
		// call get method
		
		Response response = reqSpec.get();
		
		ValidatableResponse validatableRes = response.then();
		
		// validate status code
		
		validatableRes.statusCode(200);
		
		validatableRes.statusLine("HTTP/1.1 200 OK");

		
	}

}
