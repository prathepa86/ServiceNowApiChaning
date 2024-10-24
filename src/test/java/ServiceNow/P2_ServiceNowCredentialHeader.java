package ServiceNow;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class P2_ServiceNowCredentialHeader {
	
	public String baseURI="https://dev264081.service-now.com/api/now/table/incident";
	
	
	@Test
	public void passingAuthenticationInHeader() {
		given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.baseUri(baseURI)
		.when()
		.get()
		.then()
		.statusCode(200);
				
	}

}
