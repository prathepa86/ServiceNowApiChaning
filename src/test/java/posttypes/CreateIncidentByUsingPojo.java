package posttypes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentByUsingPojo {

	public String baseURI="https://dev264081.service-now.com";
	@Test(priority=5)
	public void CreateIncidentusingPojo() {
		Pojo payload=new Pojo("1", "Incident created using pojo");
		
		Response response = given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("Content-Type","application/json")
		.body(payload)
		.baseUri(baseURI)
		.when()
		.post("/api/now/table/incident")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
		String number = jsonPath.getString("result.number");
		String sys_id = jsonPath.getString("result.sys_id");
		String short_desc = jsonPath.getString("result.short_description");
		System.out.println("Incident number is :"+number);
		System.out.println("Sys_id is :"+sys_id);
		System.out.println("Short description is:"+short_desc);
		
		
		
	}
}
