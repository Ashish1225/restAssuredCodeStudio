package day7_deserialization;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializationDemo {
	
	// converting JSON to object --> deserialization
	
	// URl = https://reqres.in/api/users
	
	@Test
	public void createUser() {
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		reqSpec.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON);
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Saurabh");
		payload.put("job", "automation");
		
		reqSpec.body(payload.toJSONString());
		
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		System.out.println("Name is : "+response.body().path("name"));
		
		ResponseBody resBody = response.getBody();
		
		// converting response body to class object
		
		JSONPostRequestResponse responseClass = resBody.as(JSONPostRequestResponse.class);
		
		Assert.assertEquals(responseClass.name, "Saurabh","Sorry name is not matched..");
		
		Assert.assertEquals(responseClass.job, "automation","Sorry job is not matched..");		
	}

}
