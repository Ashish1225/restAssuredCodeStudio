package day10_uploadfile;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ImageUploadDemo {
	
	// https://petstore3.swagger.io/api/v3/pet/3/uploadImage
	
	@Test
	public void uploadImageDemo() {
		
		File imageFile = new File("C:\\Users\\ashu2\\OneDrive\\Desktop\\backgrounddefault.jpg");
		

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://petstore3.swagger.io");
		reqSpec.basePath("/api/v3/pet/3/uploadImage");
		reqSpec.queryParam("additionalMetadata", "assd");
		reqSpec.multiPart("file", imageFile);
		reqSpec.contentType(ContentType.MULTIPART);
		
		
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched..");
		
		
	}

}
