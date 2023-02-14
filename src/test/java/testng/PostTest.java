package testng;

import static org.testng.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import pojo.ApiCore;

public class PostTest {

	ApiCore apiCore;

	@BeforeMethod
	public void setup() {
		apiCore = new ApiCore();
	}

	@Test()
	public void validatePostTestFromMyResponse() {
		Response testResponse = apiCore.PostLogin("staff.json", "/users");
		assertEquals(testResponse.statusCode(), 201);
	}

	@Test(enabled = false)
	public void validatePostTest() throws FileNotFoundException, IOException, JsonException {
		try (FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\files\\staff.json")) {
			JsonObject deserializedJsonObject = (JsonObject) Jsoner.deserialize(fileReader);
			RestAssured.baseURI = "https://reqres.in/api/";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.headers("Content-Type", "application/json");
			httpRequest.body(deserializedJsonObject.toJson());
			QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(httpRequest);
			Response response = httpRequest.post("/users");
			Reporter.log("Status code: " + response.statusCode());
			Reporter.log("Response body: " + response.getBody().asPrettyString());
			Reporter.log("Body sent: " + deserializedJsonObject.toJson());
			Reporter.log("URL: " + queryableRequestSpecification.getURI());
		}

	}
}
