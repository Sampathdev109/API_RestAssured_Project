package com.RestAssured;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject_JSON_File {
	@Test
	public void createProject() throws IOException {
		
		//Read the File
		FileInputStream fis = new FileInputStream("./data.json");
		
		//request specification
		given()
		.contentType(ContentType.JSON)
		.body(fis)
		
		//actual request
		.when()
		.post("http://localhost:8084/addProject")
		
		//
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
