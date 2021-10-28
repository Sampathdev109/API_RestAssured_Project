package com.RestAssured;

import java.util.HashMap;

import org.apache.poi.xwpf.usermodel.BodyElementType;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateProject_HashMap {
	
	public void createproject() {
	
		HashMap hm = new HashMap();
		
		hm.put("createBy", "Pragathi");
		hm.put("projectName", "Chrome2");
		hm.put("status", "Completed");
		hm.put("teamSize", 100);
		
		// request Specification
		given()
		.contentType(ContentType.JSON)
		.body(hm)
		
		//Actual Request
		.when()
		.post("http://localhost:8084/addProject");
		
		
	}

}
