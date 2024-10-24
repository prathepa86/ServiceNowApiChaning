package Regres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetReqAndRes {
@Test
public void GetAllUsers() {
	RestAssured.baseURI="https://reqres.in/api";
	RestAssured.basePath="/users";
	Response response = RestAssured.get();
	int statusCode = response.statusCode();
	Assert.assertEquals(statusCode, 200);
	System.out.println("As A string"+response.asString());
	System.out.println("As a pretty String"+response.asPrettyString());
	
}
}
