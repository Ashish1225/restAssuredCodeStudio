package day10_uploadfile;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo {
	
	// https://httpbin.org/post
	
	
	@Test
	public void uploadFile() {
		
		// create a file object
		File file = new File("C:\\Users\\ashu2\\OneDrive\\Desktop\\uploadTextFile.txt");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/post");
		reqSpec.contentType(ContentType.MULTIPART);
		
		reqSpec.multiPart("file", file);
		
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched..");
	}

}
