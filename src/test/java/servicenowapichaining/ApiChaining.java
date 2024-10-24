package servicenowapichaining;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class ApiChaining {
	
	public String baseURI="https://dev264081.service-now.com";
    public String sys_id="";
    
    @Test(priority=1)
    public void createanIncidentUsingJsonFile() {
    	File payload=new File("./data/Postbody.json");
    	Response response = given()
    	.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
    	.header("Content-Type","application/json")
    	.baseUri(baseURI)
    	.body(payload)
    	.when()
    	.post("/api/now/table/incident")
    	.then()
    	.log().all()
    	.statusCode(201)
    	.extract()
    	.response();
    	
    	JsonPath jsonPath = response.jsonPath();
    	String number = jsonPath.getString("result.number");
    	 sys_id = jsonPath.getString("result.sys_id");
    	System.out.println("Incident number is :"+number);
    	System.out.println("Sys_id is :"+sys_id);
    	
    }
    
    @Test(priority=2,dependsOnMethods ="createanIncidentUsingJsonFile" )
    public void updateAnIncident() {
    	File payload=new File("./data/UpdateApiChaining.json");
    	Response response = given()
    	.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
    	.header("Content-Type","application/json")
    	.baseUri(baseURI)
    	.body(payload)
    	.when()
    	.put("/api/now/table/incident/"+sys_id)
    	.then()
    	.statusCode(200)
    	.log().all()
    	.extract()
    	.response();
    	
    	JsonPath jsonPath = response.jsonPath();
    	sys_id = jsonPath.getString("result.sys_id");
    	String number = jsonPath.getString("result.number");
    	System.out.println("Sys_id id :"+sys_id);
    	System.out.println("Number is :"+number);
    
    }
    



}
