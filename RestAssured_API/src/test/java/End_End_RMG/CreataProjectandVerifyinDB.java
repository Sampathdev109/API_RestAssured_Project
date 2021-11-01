package End_End_RMG;

import static org.junit.Assert.assertArrayEquals;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtils.BaseClassAPI;
import GenericUtils.EndPoints;
import GenericUtils.ProjectLibrary;
import GenericUtils.RestAssuredUtility;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreataProjectandVerifyinDB extends BaseClassAPI{
	@Test
	public void createProject() throws SQLException {
		RestAssuredUtility rLib = new RestAssuredUtility();
		ProjectLibrary PLib = new ProjectLibrary("Sampathdev"+ JLib.getrandom(), "Matrix"+ JLib.getrandom(), "Completed", 20);
		Response res = given()
		.contentType(ContentType.JSON)
		.body(PLib)
		.when()
		.post(EndPoints.addProject);
		
		//Capture the expected Data
		String ExpData = RestLib.getJsonData(res,"projectName");
		System.out.println("Expected Data" + ExpData);
		
		//verify it in DB
		
		String Query = "select * from projects";
		String actData = DBLib.executeQueryAndGetData(Query, 4, ExpData);
		
		
		//validate
		Assert.assertEquals(actData, ExpData);
		System.out.println("Successful");
		
	}
}
