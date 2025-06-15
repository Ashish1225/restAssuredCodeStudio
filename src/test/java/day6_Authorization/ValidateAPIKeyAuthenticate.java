package day6_Authorization;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateAPIKeyAuthenticate {
	
	// validating API Key Authentication
	
	
	//    7c6809acad6c50a088fa70a22030ef76
	
	// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	
	@Test
	public void apiKeyAuth()
	{
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://api.openweathermap.org");
		reqSpec.basePath("/data/2.5/weather");
		reqSpec.queryParam("q", "Firozabad").queryParam("appid", "7c6809acad6c50a088fa70a22030ef76");
		
		Response response = reqSpec.get();
		
		System.out.println("Response is :"+response.body().asPrettyString());
		System.out.println("Status line :"+response.statusLine());
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched..");
	}

}
