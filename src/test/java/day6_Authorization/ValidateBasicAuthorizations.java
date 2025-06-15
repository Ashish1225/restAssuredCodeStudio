package day6_Authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateBasicAuthorizations {
	
	// about Basic Auth
	
	
	//  https://postman-echo.com/basic-auth
	
	@Test
	public void basicAuthNonPreemptive()
	{
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://postman-echo.com");
		reqSpec.basePath("/basic-auth");
		
		Response response = reqSpec.auth().basic("postman", "password").get();
		
		System.out.println("Response status line :"+response.statusLine());
	}
	
	@Test
	public void basicAuthPreemptive()
	{
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://postman-echo.com");
		reqSpec.basePath("/basic-auth");
		
		Response response = reqSpec.auth().preemptive().basic("postman", "password").get();
		
		System.out.println(response.getBody().asString());
		
		System.out.println("Response status line :"+response.statusLine());
	}

}
