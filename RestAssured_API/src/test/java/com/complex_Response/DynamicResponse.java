package com.complex_Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.List;

import javax.annotation.meta.When;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DynamicResponse {
	@Test
	public void dynamicresponse() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		//store the response
		
		String expected = "Matrix129";
		Response res = when()
				.get("/projects");
				
				//capture all the project name and store it in the list of strings
				List <String> projectName = res.jsonPath().get("projectName");
		
		for(String actual : projectName)
		{
			if(actual.equalsIgnoreCase(expected)){
				Assert.assertEquals(actual, expected);
				System.out.println(actual + "data present");
				break;
			}


		}
		
		//validate
		res.then().log().all();
		
	}


}
