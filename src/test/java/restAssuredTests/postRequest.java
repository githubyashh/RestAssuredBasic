package restAssuredTests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestUtilForTrello.APIToken;
import io.restassured.RestAssured;


public class postRequest {
	 public static APIToken enter= new APIToken();

	
	@BeforeClass
	public void putdata() {
		
		RestAssured.baseURI="https://api.trello.com";
		RestAssured.basePath="/1/boards/";
		
	}
	
	@Test 
	public void postreq() {

		given()
		
		.queryParam("key", enter.key )
		.queryParam("token", enter.token)
		.queryParam("name", "RestAssuredSelenium200")
			.contentType("application/json")
		.when()
			.post()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("name",equalTo("RestAssuredSelenium200"))
			.log().all();
			
		
	}

}
