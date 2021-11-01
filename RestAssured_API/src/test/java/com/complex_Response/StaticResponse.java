package com.complex_Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class StaticResponse {
	@Test
	public void staticResponse() {
		
		
		baseURI = "http://localhost";
		port = 8084;
		
		String expData = "TY_PROJ_1403";
		
		//store all the response
		Response res = when()
	    .get("/projects");
		
		//capture the data using json path
		String actData = res.jsonPath().get("[7].projectId");
		System.out.println(actData);
		
		//validate
		Assert.assertEquals(actData, expData);
		System.out.println(actData + "data verified");
		
		res.then().log().all();
		
	}
}
