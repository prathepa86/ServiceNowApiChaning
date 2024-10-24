package ServiceNow;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class P4_JsonExtractionInGetRequest {
	
	public String baseURI="https://dev264081.service-now.com/api/now/table/incident";
	
	
	@Test(priority=1)
	public void getFirstIncident() {
		Response response = given()
		.header("Authorization", "Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.baseUri(baseURI)
		.when()
		.get()
		.then()
		.log().all()
		.statusCode(200)
		.extract()
		.response();
		
		System.out.println(response.asPrettyString());
		
		JsonPath jsonPath = response.jsonPath();
		
		
		  Object firstIncidentNum = jsonPath.get("result[0].number");
		  System.out.println("First Incident number is:"+firstIncidentNum);
		 
		
		
	}
	
	@Test(priority=2)
	public void getAllIncidents() {
		Response response= given()
		.baseUri(baseURI)
		.header("Authorization", "Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.when()
		.get()
		.then()
		//.log().all()
		.statusCode(200)
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
      List<Object> list = jsonPath.getList("result");
      System.out.println(list);
     
		
		
		/*
		 * System.out.println("size is"+list.size());
		 * 
		 * 
		 * for(int i=0;i<list.size();i++) {
		 * System.out.println("Incident number is:"+jsonPath.get("result["+i+"].number")
		 * ); }
		 */
			 
		 
		
		
	}

}
