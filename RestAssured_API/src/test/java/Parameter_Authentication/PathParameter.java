package Parameter_Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter {
	@Test
	public void pathParameter() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParam("projID", "TY_PROJ_1402")
		
		.when()
		.get("/projects/{projID}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
