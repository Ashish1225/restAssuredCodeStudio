package day15_responseSpecification;


import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationDemo2 {
	
	ResponseSpecification responseSpec = null;
	
	// https://restful-booker.herokuapp.com/booking
	
	@BeforeClass
	public void createResponseSpec() {
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectStatusLine("HTTP/1.1 200 OK");
		responseBuilder.expectContentType(ContentType.JSON);
		responseBuilder.expectResponseTime(Matchers.lessThan(3000L));
		
		responseSpec = responseBuilder.build();
	}
	
	
	@Test
	public void getAllBookingIds() {
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com");
		reqSpec.basePath("/booking");
		Response response = reqSpec.get();
		

		response.then().spec(responseSpec)
		.body("size()", Matchers.greaterThan(0));
		
		
		//response.prettyPrint();
		/*
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK","Status line is not matched");
		Assert.assertEquals(response.contentType(),"application/json; charset=utf-8","content type is not matched");
		System.out.println(response.time());
		Assert.assertTrue(response.time()<4000L, "time is not matched");
		*/
	}
	
	@Test
	public void getBookingByFirstName() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com");
		reqSpec.basePath("/booking");
		reqSpec.queryParam("firstname", "sally").queryParam("lastname", "brown");
		Response response = reqSpec.get();
		
		response.then().spec(responseSpec);
		//response.prettyPrint();
		
		/*
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK","Status line is not matched");
		Assert.assertEquals(response.contentType(),"application/json; charset=utf-8","content type is not matched");
		System.out.println(response.time());
		Assert.assertTrue(response.time()<4000L, "time is not matched");
		*/
	}

}
