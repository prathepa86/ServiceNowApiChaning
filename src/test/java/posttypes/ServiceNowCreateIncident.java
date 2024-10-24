package posttypes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ServiceNowCreateIncident {
	
	//1. Post the change request and get the sys_id.Construct the URI for update
	
	public String baseURI="https://dev264081.service-now.com";
	@Test(priority=1)
	public void createIncidentUsingString() {
		String payload="{\"state\":\"1\",\"short_description\":\"Incident created from Rest Assured by passing data as a string\"}";
		Response response = given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("Content-Type","application/json")
		.baseUri(baseURI)
		.body(payload)
		.when()
		.post("/api/now/table/incident")
		.then()
		.log().all()
		.extract()	
		.response();
		JsonPath jsonPath = response.jsonPath();
		String sys_id = jsonPath.getString("result.sys_id");
		String number = jsonPath.getString("result.number");
		System.out.println("Sys_Id is:"+sys_id);
		System.out.println("Number is:"+number);
		
	}
	
	@Test(priority=2)
	public void createIncidentByPassingBodyAsJsonFile() {
		File payLoad=new File("./data/Postbody.json");
		Response response = given()	
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("Content-Type","application/json")
		.baseUri(baseURI)
		.body(payLoad)
		.when()
		.post("/api/now/table/incident")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
		String sys_id = jsonPath.getString("result.sys_id");
		String number = jsonPath.getString("result.number");
		System.out.println("Sys_id is :"+sys_id);
		System.out.println("number is :"+number);
		}
	
	
	@DataProvider(name="JsonFiles")
	public String[] fileNameAsData() {
		String[] fileName= {"PostbodyDP1","PostbodyDP2"};
		return fileName;
	}
	
	@Test(priority=3,dataProvider ="JsonFiles")
	public void createIncidentByPassingBodyAsJsonFileUsingDataProvider(String fileName) {
		File payload=new File("./data/"+fileName+".json");
		Response response = given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("Content-Type","application/json")
		.baseUri(baseURI)
		.body(payload)
		.when()
		.post("/api/now/table/incident")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
		String sys_id = jsonPath.getString("result.sys_id");
		String number = jsonPath.getString("result.number");
		System.out.println("sys_id is:"+sys_id);
		System.out.println("number:"+number);
	}
	
	@Test(priority=4)
	public void createIncidentByPassingBodyAsMapCollection() {
		Map<String,String> map=new HashMap<String,String>();
		map.put("state", "1");
		map.put("short_description", "Creating incident from RestAssured and body as Map");
		
		Response response = given()
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("Content-Type","application/json")
		.baseUri(baseURI)
		.body(map)
		.when()
		.post("/api/now/table/incident")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jsonPath = response.jsonPath();
		String sys_id = jsonPath.getString("result.sys_id");
		String number = jsonPath.getString("result.number");
		System.out.println("Sys id is :"+sys_id);
		System.out.println("number is :"+number);
		
		
	}
	
	

}
