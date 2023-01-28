package restAssuredTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtilForTrello.APIToken;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;


public class getRequest {
	 public static APIToken enter= new APIToken();

	@BeforeTest
	public void preTest() {
		RestAssured.baseURI="https://api.trello.com";
		RestAssured.basePath="/1/boards/63d48edbbbb69e10b7926515";
	}
	
	@Test
	public void getRequest() {
		given()	
			.queryParam("key", enter.key)
			.queryParam("token", enter.token)
			
		.when()
			.get()
		.then()
			.statusCode(200).and()
			.assertThat().body("name",equalTo("YashRestAssured1"))
			.time(Matchers.lessThan(2000L))
			.log().all();
		
	}

}
