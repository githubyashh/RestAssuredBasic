package restAssuredTests;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestUtilForTrello.APIToken;
import io.restassured.RestAssured;


public class deleteRequest {

 public static APIToken enter= new APIToken();
	
	@BeforeClass
	public static void putenter() {
	
		RestAssured.baseURI="https://api.trello.com";
		RestAssured.basePath="/1/boards/{id}";
	}
	
	
	@Test 
	public void postreq() {
		given()
		.queryParam("key", enter.key )
		.queryParam("token", enter.token )
		.pathParam("id", "63d5f904cadfc71dc4a81958")
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}

}
