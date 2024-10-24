package hamcrest;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;

public class HamcrestValidationInMockServer {
	
	public String baseURI="https://46fea677-16e9-4a24-a2b0-24171b49f7cb.mock.pstmn.io";
	
	@Test
	public void getCourseNames() {
		 Response response = given()
		.header("course","all")
		.baseUri(baseURI)
		.when()
		.get("/courses")
		.then()
		.statusCode(200)
		.log().all()
		.extract()
		.response();
		 
		 JsonPath jsonPath = response.jsonPath();
		 List<Object> list = jsonPath.getList("courses");
		 System.out.println("Size is:"+list.size());
		 for(int i=0;i<list.size();i++) {
			 System.out.println("course name :"+jsonPath.getString("courses["+i+"].course_name"));
		 }
		 
		
		 
		
	}
	

}
