package Parameter_Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2authentication {
	@Test
	public void oauth2authentication() {
		//generate token
		 Response res = given()
		.formParam("client_id", "SDET-21")
		.formParam("client_secret", "9cdd532c961a613e4c1e29a54979f4a6")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri ", "http://example.com")
		.formParam("code", "authorization_code")
	
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		res.then().log().all();
		 
		//capture the token
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		//create a new request to access the token
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "2403")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
		
	}

}


