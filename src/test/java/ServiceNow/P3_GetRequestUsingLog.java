package ServiceNow;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class P3_GetRequestUsingLog {
	
	public String baseURI="https://dev264081.service-now.com";
	
	
	@Test
	public void GetRequestWithLogDetails() {
		given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.baseUri(baseURI)
		.when()
		.get("/api/now/table/incident")
		.then()
		.log().all()
		.and()
		.statusCode(200);
		
	}
	

}
