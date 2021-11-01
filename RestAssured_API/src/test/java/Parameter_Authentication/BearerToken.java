package Parameter_Authentication;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

public class BearerToken {
	@Test
	public void bearerToken() {
		
		HashMap hm = new HashMap();
		hm.put("name","REST_SDET21-Repo");
		
		given()
		.auth()
		.oauth2("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")
		.body(hm);
		
		when()
		.post("https://api.github.com/user/repo")
		
		.then().log().all();
	
	}

}
