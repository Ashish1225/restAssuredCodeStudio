package day12_pojoDemo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NestedComplexJSONObjectDemo {
	
	
	@Test
	public void createUser() throws JsonProcessingException {
		
		NestedJSONPOJOClass requestPayload = new NestedJSONPOJOClass();
		requestPayload.setCompanyname("Times internet");
		requestPayload.setCity("Gurugram");
		requestPayload.setState("haryana");
		requestPayload.setStreet("udhyog Vihar phase 3");
		requestPayload.setPincode(274284);
		
		
		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("SBI"); 
		banks.add("AXIS");
		banks.add("ICICI");
		requestPayload.setBankaccounts(banks);
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.setFirstName("Ashish");
		s2.setFirstName("Neelam");
		s3.setFirstName("Mangal");
		
		s1.setLastName("Rathour");
		s2.setLastName("Rathour");
		s3.setLastName("yadav");
		
		s1.setAge(30);
		s2.setAge(25);
		s3.setAge(29);
		
		s1.setGender("Male");
		s2.setGender("Female");
		s3.setGender("Male");
		
		s1.setSalary(33430.43);
		s2.setSalary(34536.13);
		s3.setSalary(73434.43);
		
		StudentAddress studentAdress1 = new StudentAddress();
		studentAdress1.setStreet("Civil Lines");
		studentAdress1.setCity("Firozabad");
		studentAdress1.setState("Uttar Pradesh");
		studentAdress1.setPincode(283837);
		s1.setAddress(studentAdress1);
		
		StudentAddress studentAdress2 = new StudentAddress();
		studentAdress2.setStreet("jalalpur");
		studentAdress2.setCity("Firozabad");
		studentAdress2.setState("Uttar Pradesh");
		studentAdress2.setPincode(283837);
		s2.setAddress(studentAdress2);
		
		StudentAddress studentAdress3 = new StudentAddress();
		studentAdress3.setStreet("park jdskdj");
		studentAdress3.setCity("Lucknow");
		studentAdress3.setState("Uttar Pradesh");
		studentAdress3.setPincode(743745);
		s3.setAddress(studentAdress3);
		
		List<Student> employeePayload = new ArrayList<Student>();
		employeePayload.add(s1);
		employeePayload.add(s2);
		employeePayload.add(s3);
		
		requestPayload.setEmployeeList(employeePayload);
		
		// convert class object to json object  as string
		ObjectMapper objMapper = new ObjectMapper();
		String jsonPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		
		System.out.println(jsonPayload);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonPayload);
		Response response = reqSpec.post();
		
		System.out.println("Response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched..");
		
		System.out.println("-------------- Deserialization --------------");
		
		NestedJSONPOJOClass stud = objMapper.readValue(jsonPayload, NestedJSONPOJOClass.class);
		
		
		
		
	}

}
