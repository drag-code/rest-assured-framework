package pojo;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.SerializationUtil;

public class ApiCore {

	private Response response;
	private CustomRequest customRequest;
	
	public ApiCore(String resource, String baseURI) {
		setBaseURI(baseURI);
		customRequest = new CustomRequest(resource);
	}
	
	public ApiCore(String baseURI) {
		setBaseURI(baseURI);
		customRequest = new CustomRequest();
	}
	
	public ApiCore(String resource, String fileName, String baseURI) {
		setBaseURI(baseURI);
		String body = SerializationUtil.deserializeFromFileAsJsonString(fileName);
		customRequest = new CustomRequest(resource, body);
	}
	
	public void setBaseURI(String baseURI) {
		RestAssured.baseURI = baseURI;
	}

	public CustomRequest getCustomRequest() {
		return customRequest;
	}
	
	public Response post() {
		response = customRequest.post();
		return response;
	}

	public Response get() {
		response = customRequest.get();
		return response;
	}
	
	public Response get(Map<String, String> params) {
		customRequest.addQueryParams(params);
		return get();
	}
	
	public Response put() {
		response = customRequest.put();
		return response;
	}
	
	public Response delete() {
		response = customRequest.delete();
		return response;
	}
}
