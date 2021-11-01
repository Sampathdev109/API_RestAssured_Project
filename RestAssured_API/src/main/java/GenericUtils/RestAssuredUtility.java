package GenericUtils;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import io.restassured.response.Response;

/**
 * This class contains methods pertaining to RestAssured
 * @author SAMPATHDEV
 * @param <Response>
 *
 */
public class RestAssuredUtility {
	
	public String getJsonData(Response res, String jsonPath) {
		
		String value = res.jsonPath().get(jsonPath);
		return value;
		
	}
}

