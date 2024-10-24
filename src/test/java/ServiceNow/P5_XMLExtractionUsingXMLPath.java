package ServiceNow;

import org.testng.annotations.Test;


import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class P5_XMLExtractionUsingXMLPath {
	
	public String baseURI="https://dev264081.service-now.com";

	
	@Test
	public void XmlExtractionUsingXmlPath() {
		Response response = given()
		.baseUri(baseURI)
		.header("Authorization", "Basic YWRtaW46UHJhdGhlcGFAMTk4Ng==")
		.header("accept","application/xml")
		.when()
		.get("/api/now/table/incident")
		.then()
		.log().all()
		.extract()
		.response();
		//System.out.println(response.asPrettyString());
		XmlPath xmlPath = response.xmlPath();
		//System.out.println("First Incident number: "+xmlPath.get("response.result[0].number"));
	 List<Object> list = xmlPath.getList("response.result");
	 System.out.println("The size is :"+list.size()); 
	 System.out.println(list);
	 
		/*
		 * for(int i=0;i<list.size();i++) {
		 * System.out.println("The sys_id is :"+xmlPath.get("response.result["+i+
		 * "].sys_id")); }
		 */
	
	}
}
