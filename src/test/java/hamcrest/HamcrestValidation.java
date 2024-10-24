package hamcrest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestValidation {
	public String baseURI="https://dev264081.service-now.com/api/now/table/incident";
	@Test(priority=1)
	public void getAllUsers() {
		Response response = given()
		.baseUri(baseURI)
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.when()
		.get()
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
   String FirstIncidentNumber = jsonPath.getString("result[0].number");
   assertThat(FirstIncidentNumber, equalTo("INC0000060"));
   
   Assert.assertEquals(FirstIncidentNumber, "INC0000060");
		
	}
	
	@Test(priority=2)
	public void validateNumbers() {
		Response response = given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.baseUri(baseURI)
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all()
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
		String FirstImpactNumber  = jsonPath.getString("result[0].impact");
		int impact=Integer.parseInt(FirstImpactNumber);
		assertThat(impact, equalTo(2));
		assertThat(impact,greaterThanOrEqualTo(2));
		assertThat(impact, greaterThan(1));
	}
	
	@Test(priority=3)
	public void validateString() {
		 given()
				.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
				.baseUri(baseURI)
				.when()
				.get()
				.then()
				.statusCode(200)
				.body("result[0].number",startsWith("INC"))
		        .body("result[0].short_description",equalTo("Unable to connect to email"))
		        .body("result[0].work_notes", emptyOrNullString())
		        .body("result[0].number", containsString("000"));
		
	}

}
