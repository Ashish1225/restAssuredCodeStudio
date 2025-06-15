package day1Get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstGetReq {
	
	// https://reqres.in/api/users/2
	
	// header - x-api-key: reqres-free-v1
	
	@Test
	void testCase01() 
	{
		RequestSpecification request = RestAssured.given();
		request.header("x-api-key","reqres-free-v1");
		Response response = request.get("https://reqres.in/api/users/2");
		//Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.asString());
		// validate status code
		System.out.println("status code : "+response.getStatusCode());
	}
	
	
	@Test
	void testCase02() 
	{
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.asString());
		// validate status code
		System.out.println("status code : "+response.getStatusCode());
		
		
	}


}
