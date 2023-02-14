package pojo;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Constants;

public class CustomResponse {
	String resource;
	RequestSpecification httpRequest;
	Map<String, String> headers;
	
	public CustomResponse(String resource) {
		this.resource = resource;
		RestAssured.baseURI = Constants.BASE_URI;
		httpRequest = RestAssured.given();
	}
	
	@SuppressWarnings("serial")
	public CustomResponse(String resource, String body) {
		this(resource);
		headers = new HashMap<String, String>() {{
			put("Conten-Type", "application/json");
		}};
		httpRequest.headers(headers);
		httpRequest.body(body);
	}
	
	public Response getResponseFromPost() {
		 return httpRequest
		.when()
		.post(resource);
	}
}
