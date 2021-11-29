package com.complex_Response;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericUtils.JavaUtility;
import GenericUtils.ProjectLibrary;

public class CreateProject_POJO {
	@Test
	public void createproject() {
		
		JavaUtility jLib = new JavaUtility();
		baseURI = "http:/localhost";
		port = 8084;
		
		//read data through pojo class
		ProjectLibrary pLib = new ProjectLibrary("Sampathdev", "Chivas" + jLib.getrandom(), "Completed", 100);
		
		//request speecification
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		//request
		
		.when()
		.post("/addproject");
		
		
	
	
	
	}
	
	

}
