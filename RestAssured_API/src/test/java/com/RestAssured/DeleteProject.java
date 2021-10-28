package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProject {
	@Test
	public void DeletePproject() {
		
		 Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1204");
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType("application/JSON");
		 validate.assertThat().statusCode(204);
		 validate.log().all();
	 
	}

}
