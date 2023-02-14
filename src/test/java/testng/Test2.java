package testng;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Test2 {
	
	@Test(enabled = false)
	public void validateFullResponseLonger() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.get("/users/2").then().body("data.id", equalTo(2));
		httpRequest.get("/users/2").then().body("data.email", equalTo("janet.weaver@reqres.in"));
		httpRequest.get("/users/2").then().body("data.first_name", equalTo("Janet"));
		httpRequest.get("/users/2").then().body("data.last_name", equalTo("Weaver"));
		httpRequest.get("/users/2").then().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
		httpRequest.get("/users/2").then().body("support.url", equalTo("https://reqres.in/#support-heading"));
		httpRequest.get("/users/2").then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		
		Reporter.log("Sucess status code and response items validation");
	}
	
	@Test(enabled = false)
	public void validateFullResponseSimpler() {
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.assertThat()
		.statusCode(200)
		.assertThat()
		.body("data.id", equalTo(2))
		.and()
		.body("data.email", equalTo("janet.weaver@reqres.in"))
		.and()
		.body("data.first_name", equalTo("Janet"))
		.and()
		.body("data.last_name", equalTo("Weaver"))
		.and()
		.body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
		.and()
		.body("support.url", equalTo("https://reqres.in/#support-heading"))
		.and()
		.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		Reporter.log("Sucess status code and response items validation");
	}
	
	@Test()
	public void validateFullResponseLonger2() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.get("/unknown/2").then().body("data.id", equalTo(2));
		httpRequest.get("/unknown/2").then().body("data.name", equalTo("fuchsia rose"));
		httpRequest.get("/unknown/2").then().body("data.year", equalTo(2001));
		httpRequest.get("/unknown/2").then().body("data.color", equalTo("#C74375"));
		httpRequest.get("/unknown/2").then().body("data.pantone_value", equalTo("17-2031"));
		httpRequest.get("/unknown/2").then().body("support.url", equalTo("https://reqres.in/#support-heading"));
		httpRequest.get("/unknown/2").then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		
		Reporter.log("Sucess status code and response items validation");
	}
	
	@Test()
	public void validateFullResponseSimpler2() {
		given()
		.when()
		.get("https://reqres.in/api/unknown/2")
		.then()
		.assertThat()
		.statusCode(200)
		.assertThat()
		.body("data.id", equalTo(2))
		.and()
		.body("data.name", equalTo("fuchsia rose"))
		.and()
		.body("data.year", equalTo(2001))
		.and()
		.body("data.color", equalTo("#C74375"))
		.and()
		.body("data.pantone_value", equalTo("17-2031"))
		.and()
		.body("support.url", equalTo("https://reqres.in/#support-heading"))
		.and()
		.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		Reporter.log("Sucess status code and response items validation");
	}
}
