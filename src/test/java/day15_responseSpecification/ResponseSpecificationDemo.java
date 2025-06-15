package day15_responseSpecification;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseSpecificationDemo {
	
	// https://restful-booker.herokuapp.com/booking
	
	
	@Test
	public void getAllBookingIds() {
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com");
		reqSpec.basePath("/booking");
		Response response = reqSpec.get();
		//response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK","Status line is not matched");
		Assert.assertEquals(response.contentType(),"application/json; charset=utf-8","content type is not matched");
		System.out.println(response.time());
		Assert.assertTrue(response.time()<4000L, "time is not matched");
		
	}
	
	@Test
	public void getBookingByFirstName() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com");
		reqSpec.basePath("/booking");
		reqSpec.queryParam("firstname", "sally").queryParam("lastname", "brown");
		Response response = reqSpec.get();
		//response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK","Status line is not matched");
		Assert.assertEquals(response.contentType(),"application/json; charset=utf-8","content type is not matched");
		System.out.println(response.time());
		Assert.assertTrue(response.time()<4000L, "time is not matched");
	}

}
