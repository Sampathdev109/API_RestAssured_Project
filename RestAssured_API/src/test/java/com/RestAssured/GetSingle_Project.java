package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetSingle_Project {
	@Test
	public void GetSingle() {
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1203");
		  String Type = response.getContentType();
		 long Time =  response.getTime();
		 int StatusCode =  response.statusCode();
		System.out.println(Type);
		System.out.println(Time);
		System.out.println(StatusCode);
		 
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType("application/JSON");
		validate.assertThat().statusCode(200);
		validate.log().all();
		
		
	}
}
