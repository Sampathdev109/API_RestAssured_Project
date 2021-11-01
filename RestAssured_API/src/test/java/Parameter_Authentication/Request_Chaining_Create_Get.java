package Parameter_Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericUtils.JavaUtility;
import GenericUtils.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Request_Chaining_Create_Get {

	@Test
	public void requestchaining() {
		JavaUtility jLIB = new JavaUtility();
	baseURI = "http://localhost";
	port = 8084;
	
	//create a project
	ProjectLibrary pLIB = new ProjectLibrary("Samton", "Matrices"+ jLIB.getrandom(), "Completed", 100);
	
	Response res = given()
	.contentType(ContentType.JSON)
	.body(pLIB)
	.when()
	.post("/addProject");
	
	//capture the Project ID using the path
	 String MyProjID = res.jsonPath().get("projectId");
	 System.out.println(MyProjID);
	 
	 res.then().log().all();
	 
	 //this is second request to read the same project created in 1st Response
	 given()
	 .pathParam("projID", MyProjID)
	 
	 .when() 
	 .get("/projects/{projID}")
	 .then().assertThat().statusCode(200).log().all();
	 
	
	
	}
}
