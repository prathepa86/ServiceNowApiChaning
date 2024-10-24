package jsonschemavalidator;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

public class ServiceNowJsonSchemaValidator {
	public String baseURI="https://dev264081.service-now.com";
	
	@Test
	public void SchemaValidator() {
		File payload=new File("./data/Postbody.json");
		File Schema=new File("./data/schemaValidator.json");
		given()
		.baseUri(baseURI)
		.header("Authorization","Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("Content-Type","application/json")
		.body(payload)
		.when()
		.post("/api/now/table/incident")
		.then()
		.log().all()
		.assertThat()
		.body(matchesJsonSchema(Schema));
	}

}
