package day8_retreiveRequestSpecificationDetails;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class RetreiveRequestSpecificationDetails {
	
	public void createUser()
	{
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		reqSpec.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON);
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Neelam");
		payload.put("job", "House Wife");
		
		reqSpec.body(payload.toJSONString());
		
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);
		
		String retreiveBaseUri = queryRequest.getBaseUri();
		System.out.println("base URI is :"+retreiveBaseUri);
		
		String retreiveBasePath = queryRequest.getBasePath();
		System.out.println("base path is :"+retreiveBasePath);
		
		String retreiveBody = queryRequest.getBody();
		System.out.println("Request Body is :"+retreiveBody);
		
		
		
		Response response = reqSpec.post();
	}

}
