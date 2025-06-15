package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	// https://reqres.in/api/users/2
	
	
	@Test
	public void getSingleUser() {
		
		// get request-specification of the request
			
		RequestSpecification reqSpec = RestAssured.given();
		// specify the url
		
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users/2");
		
		Response response = reqSpec.get();
		
		// validate response header
		String contentType = response.getHeader("content-Type");
		System.out.println("Content type header value is :"+contentType);
		
		
		Headers allHeaders = response.getHeaders();
		
		for(Header head : allHeaders) {
			System.out.println("key :"+head.getName() +" --> value :"+head.getValue());
		}
		
		Assert.assertEquals(contentType, "application/json; charset=utf-8","Content is not matched with expected..");
	
}

}
