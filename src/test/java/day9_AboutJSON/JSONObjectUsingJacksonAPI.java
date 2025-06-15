package day9_AboutJSON;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class JSONObjectUsingJacksonAPI {


	@Test
	public void createUSer() {

		// create ObjectMapper class instance

		ObjectMapper objMapper = new ObjectMapper();

		// create object node i.e. json node
		ObjectNode userDetails = objMapper.createObjectNode();

		userDetails.put("firstname", "AShish");
		userDetails.put("lasttname", "Rathour");
		userDetails.put("age",30);
		userDetails.put("salary", 50000);
		userDetails.put("isMarried", true);

		ObjectNode techskils = objMapper.createObjectNode();
		techskils.put("programming", "java");
		techskils.put("webAutomation", "Selenium");
		techskils.put("ApiAutomation", "RestAssured");

		userDetails.set("techSkill", techskils);
		
		// adding array in object
		ArrayNode hobbies = objMapper.createArrayNode();
		hobbies.add("Singing");
		hobbies.add("Dancing");
		hobbies.add("Painting");
		
		userDetails.set("Hobby", hobbies);
		
		// another way of aading Array in object node
		
		userDetails.set("Travelling", objMapper.convertValue(Arrays.asList("Nainital","Rishikesh","Banaras"), JsonNode.class));

		// print userDetails JSON object

		try {
			String userDetailsString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);

			System.out.println("created JSON node is :"+userDetailsString);

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		// retrieve fields value

		String fname = userDetails.get("firstname").asText();
		System.out.println("first name is = "+fname);

		Boolean maritalStatus = userDetails.get("isMarried").asBoolean();
		System.out.println("Is Married ? "+maritalStatus);

		String techSkil = userDetails.get("techSkill").get("ApiAutomation").asText();
		System.out.println("Techinal skill is :"+techSkil);

		//retrieve all fields name
		System.out.print("\n------------print all fields name ------------\n");
		Iterator<String> allfields = userDetails.fieldNames();

		while(allfields.hasNext()) {
			System.out.println(allfields.next());
		}

		//retrieve all fields name
		System.out.print("\n------------print all fields values ------------\n");
		Iterator<JsonNode> allvalues = userDetails.elements();

		while(allvalues.hasNext()) {
			System.out.println(allvalues.next());
		}
		
		// retrieving fields and value together
		System.out.print("\n------------print all fields and values ------------\n");
		Set<Entry<String, JsonNode>> fieldAndValues = userDetails.properties();
		
		for(Entry<String, JsonNode> fieldAndVale:fieldAndValues) {
			System.out.println("fields name :"+fieldAndVale.getKey());
			System.out.println("values name :"+fieldAndVale.getValue());
		}
		
		// remove a fields from json object
		String removedFirstname = userDetails.remove("firstname").asText();
		
		System.out.println("removed first name :"+removedFirstname);
		
		try {
			String userDetailsString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);

			System.out.println("After removed method JSON node is :"+userDetailsString);

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		// update fields in json object or json node
		
		userDetails.put("firstname", "Neelam");
		try {
			String userDetailsString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);

			System.out.println("After update method JSON node is :"+userDetailsString);

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		
		
		techskils.put("programming", "Pyhton");
		userDetails.set("techSkill", techskils);
		
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		reqSpec.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON);
		reqSpec.body(userDetails);
		Response response = reqSpec.post();
		
		System.out.println("-------------- Print HTTP response -----------------");
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201,"Status code is not matched..");
	}

}
