package ServiceNow;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class P6_CreateAnIncident {
	
	public String baseURI="https://dev264081.service-now.com/api/now/table/incident";
	
	
	@Test
	public void CreateAnIncident() {
		String payload="{ \r\n"
				+ "    \"state\": \"1\",\r\n"
				+ "    \"short_description\": \"Creating the post request from Postman API\"\r\n"
				+ "\r\n"
				+ "}";
		Response response = given()
		.baseUri(baseURI)
		.header("Content-Type","application/json")
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.body(payload)
		.when()
		.post()
		.then()
		.statusCode(201)
		.extract()
		.response();
	JsonPath jsonPath = response.jsonPath();
	System.out.println(response.asPrettyString());
	System.out.println("Incident number is: "+jsonPath.get("result.number"));
	
		
		
	}

}
