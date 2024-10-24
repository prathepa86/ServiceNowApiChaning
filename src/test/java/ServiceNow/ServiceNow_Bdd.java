package ServiceNow;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ServiceNow_Bdd {
	
	public String baseURI="https://dev264081.service-now.com";
  @Test
  public void basicRegAndRes() {
	  
	  Response res = given()
	  .auth()
	  .basic("admin", "Prathepa@1986")
	  .baseUri(baseURI)
	  .when()
	  .get("/api/now/table/incident");
	  System.out.println(res.asPrettyString());
	  System.out.println(res.statusCode());
	  
  }
}
