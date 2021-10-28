package com.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ModifyProject {
	
@Test
	public void modifyProject() {
		
	
	JSONObject JObj = new	JSONObject();
	 JObj.put("createdBy", "Sampathdev");
	 JObj.put("projectName", "Matrix129");
	 JObj.put("status", "Completed");
	 JObj.put("teamSize", 100);
	 
	RequestSpecification ReqSpec = RestAssured.given();
	
	ReqSpec.contentType(ContentType.JSON);
	ReqSpec.body(JObj);
	
	Response resp = ReqSpec.patch("http://localhost:8084/projects/TY_PROJ_1203");
   ValidatableResponse validate = resp.then();
   validate.assertThat().statusCode(201);
   validate.assertThat().contentType("Application/JSON");
   validate.log().all();

}}
