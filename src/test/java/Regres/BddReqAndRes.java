package Regres;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BddReqAndRes {
	@Test
	public void GetRequestUsingBdd() {
		 Response response = given()
		.baseUri("https://reqres.in/api/users")
		.when()
		.get()
		.then()
		.statusCode(200)
		.extract()
		.response();
		 System.out.println(response);
	}
	
}
