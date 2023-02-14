package testng;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {
	@Test
	public void validateFullResponse() {

		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest =  RestAssured.given();
		Response response = httpRequest.get("/users/2");

		System.out.println(response.getBody().asPrettyString());
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(200, statusCode);
		Reporter.log("Sucess 200 validation");

	}

	@Test
	public void bodyIsValid() {
		baseURI = "https://reqres.in/api/";
		get("/users/2").then().body("data.first_name", equalTo("Janet"));
		get("/users/2").then().body("data.last_name", equalTo("Weaver"));
		Reporter.log("Sucess first_name and last_name validation");
	}
	
	@Test(enabled = true)
	public void bodyIsValidModified() {
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.assertThat()
		.statusCode(200)
		.assertThat()
		.contentType(ContentType.JSON);
		Reporter.log("Sucess staus code and content type validation");
	}
}
