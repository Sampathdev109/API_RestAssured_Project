package GenericUtils;
import org.testng.annotations.AfterSuite;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClassAPI {
	
	public	DataBaseUtility DBLib = new DataBaseUtility();
	public	RestAssuredUtility RestLib = new RestAssuredUtility();
	public	JavaUtility JLib = new JavaUtility();
	
	@BeforeSuite
	public void bsCongif() throws Throwable{
		
		DBLib.connectToDB();
		baseURI = "http://localhost";
	    port = 8084;
	}
	@AfterSuite
	public void asConfig() throws Throwable {
		DBLib.closeDB();
		
	}
	
	

}
