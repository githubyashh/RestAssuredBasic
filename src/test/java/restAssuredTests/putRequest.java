package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestUtilForTrello.APIToken;
import io.restassured.RestAssured;

public class putRequest {
	 public static APIToken enter= new APIToken();
	public static Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
		public void putenter() {
			map.put("name", "RestAssuredSeleniumLot");
		}
		
		@Test 
		public void postreq() {
		
			RestAssured.baseURI="https://api.trello.com";
			RestAssured.basePath="/1/boards/{id}";
			
			given()
				.queryParam("key", enter.key)
				.queryParam("token", enter.token)
				.pathParam("id", "63d5f904cadfc71dc4a81958")
				.body(map)
				.contentType("application/json")
			.when()
				.put()
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.log().all();
				
			
		}
}
