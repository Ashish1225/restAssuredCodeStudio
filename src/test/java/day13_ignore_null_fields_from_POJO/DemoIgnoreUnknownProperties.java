package day13_ignore_null_fields_from_POJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoIgnoreUnknownProperties {
	
	
	@Test
	public void test1() throws JsonMappingException, JsonProcessingException {
		
		String payload = "{\r\n"
				+ "  \"firstname\" : \"Ashish\",\r\n"
				+ "  \"lastname\" : \"Rathour\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"salary\" : 564656.0,\r\n"
				+ "  \"age\" : 30,\r\n"
				+ "  \"fullname\" : \"Ashish Rathour\",\r\n"
				+ "  \"married\" : false\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		// using Object Mapper we can ignore unknown property
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		EmployeePOJOFOrUnknownProperties emp2 = objMapper.readValue(payload, EmployeePOJOFOrUnknownProperties.class);
		
		System.out.println(emp2.getFirstname());
		System.out.println(emp2.getLastname());
		System.out.println(emp2.getGender());
		System.out.println(emp2.getAge());
		System.out.println(emp2.getSalary());
		System.out.println(emp2.isMarried());
		
	}

}
