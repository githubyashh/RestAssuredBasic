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
			RestAssured.basePath="/1/boards/63d48edbbbb69e10b7926515";
			
			given()
				.queryParam("key", enter.key)
				.queryParam("token", enter.token)
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
