package ServiceNow;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class P1_BddGetReqAndRes {
	public String baseURI="https://dev264081.service-now.com/api/now/table/incident";
	
	@Test
	public void getAllIncident() {
		Response response = given()
		    .auth()
		   .basic("admin","Prathepa@1986")
		   .baseUri(baseURI)
		   .when()
		   .get();

		System.out.println("***********************");
		System.out.println(response.asPrettyString());
		//System.out.println(response.asString());
		System.out.println("Status code :"+response.statusCode());
		
	}

}
