package Regres;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P2_ReqAndRes {
	int statusCode;
	
	
	@BeforeClass
	public void baseURL() {
		RestAssured.baseURI="https://reqres.in/api/users";
	
	}
	
	
	@Test(priority=1)
	public void getAllUsers() {
		Response response = RestAssured.get();
	statusCode = response.statusCode();
	System.out.println("As a string "+response.asString());
	System.out.println("As a Pretty string "+response.asPrettyString());
	}
	
	@Test(priority=2)
	public void getOneUser() {
		Response response = RestAssured.get("/2");
	  statusCode = response.statusCode();
	  System.out.println("As a string "+response.asString());
	  System.out.println("As a Pretty string "+response.asPrettyString());
	}
	
	@AfterMethod
	public void testCaseValidation() {
		Assert.assertEquals(statusCode, 200);
	}

}
