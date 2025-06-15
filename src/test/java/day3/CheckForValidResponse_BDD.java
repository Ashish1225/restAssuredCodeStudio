package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class CheckForValidResponse_BDD {
	
	//https://reqres.in/api/users/2
	
	// validate response status using Assert in BDD style
	
	@Test
	public void getSingleUser_BDD() {
		
		baseURI = "https://reqres.in/api/users/2";
		
		given()
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
	}
	

}
