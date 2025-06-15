package day6_Authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateDigestAuthorization {
	
	// https://httpbin.org/digest-auth/undefined/ashish/ashish
	
	@Test
	public void digestAuth()
	{
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/digest-auth/undefined/ashish/ashish");
		
		Response response = reqSpec.auth().digest("ashish", "ashish").get();
		
		System.out.println(response.body().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200,"Status code is not matched..");
	}

}
