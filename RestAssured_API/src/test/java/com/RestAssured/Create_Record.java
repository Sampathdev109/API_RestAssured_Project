package com.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Create_Record {
	@Test
	public void CreateRecord() {
	 JSONObject JObj = new	JSONObject();
	 JObj.put("createdBy", "Sampathdev0119");
	 JObj.put("projectName", "Matrix125");
	 JObj.put("status", "Completed");
	 JObj.put("teamSize", 100);
	 
	RequestSpecification ReqSpec = RestAssured.given();
	
	ReqSpec.contentType(ContentType.JSON);
	ReqSpec.body(JObj);
	
	Response resp = ReqSpec.post("http://localhost:8084/addProject");
    ValidatableResponse validate = resp.then();
    validate.assertThat().statusCode(201);
    validate.assertThat().contentType("Application/JSON");
    validate.log().all();

}}
