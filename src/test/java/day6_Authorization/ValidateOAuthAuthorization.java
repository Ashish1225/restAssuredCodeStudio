package day6_Authorization;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateOAuthAuthorization {
	
	
	// Client ID = AZ2jvf0MdvUXY9KtsmBT0qQo4lJLuwwm_33fOMh65zJppdRZyNwqblCeM6hfwEzkpvHBjtZVWVQO0MJI
	
	// Secret = EJjrYD9X2mJmAcUMEX2nxmwZp2RA_hUG7jJ_hbspV8nJueaQYrymOiM96ooNFpNj4hVbnIaHDm-bMH7Q
	
	// URL = https://api-m.sandbox.paypal.com/v1/oauth2/token
	
	String accessToken;
	RequestSpecification reqSpec;
	Response response;
	
	@Test
	public void oAuthGetAccessToken()
	{
		
		String clientId = "AZ2jvf0MdvUXY9KtsmBT0qQo4lJLuwwm_33fOMh65zJppdRZyNwqblCeM6hfwEzkpvHBjtZVWVQO0MJI";
		String secretId = "EJjrYD9X2mJmAcUMEX2nxmwZp2RA_hUG7jJ_hbspV8nJueaQYrymOiM96ooNFpNj4hVbnIaHDm-bMH7Q";
		reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://api-m.sandbox.paypal.com");
		reqSpec.basePath("/v1/oauth2/token");
		
		reqSpec.auth().preemptive().basic(clientId, secretId)
				.param("grant_type", "client_credentials");
		
		response = reqSpec.post();
		
		response.prettyPrint();
		
		System.out.println("status corde :"+response.statusCode());
		System.out.println("status line :"+response.statusLine());
		
		// get Access Token from response
		
		
		accessToken = response.getBody().path("access_token");
		
		System.out.println("Access token is :" + accessToken);
		
		
	}
	
	
	// fetch Access token from the response of previous request 
	
	@Test(dependsOnMethods = "oAuthGetAccessToken")
	public void listInvoiceUsingAccessToken()
	{
		reqSpec = RestAssured.given();
		reqSpec.baseUri("https://api-m.sandbox.paypal.com");
		reqSpec.basePath("/v1/invoicing/invoices");
		reqSpec.auth().oauth2(accessToken).queryParam("page", "3")
		.queryParam("page_size", "4").queryParam("total_count_required", "true");
		
		response = reqSpec.get();
		
		response.prettyPrint();
	}

}
