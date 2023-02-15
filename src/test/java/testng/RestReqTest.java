package testng;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojo.ApiCore;
import pojo.User;
import pojo.User2;
import util.Constants;
import util.FileUtil;

public class RestReqTest {

	ApiCore apiCore;
	Response testResponse;

	@BeforeTest
	public void setup() {
		User user = new User();
		user.setName("Esteban Alexis");
		user.setJob("Junior QA Professional");
		FileUtil.createJsonFile(user, "user.json");
		User2 user2 = new User2();
		user2.setEmail("eve.holt@reqres.in");
		user2.setPassword("pistol");
		FileUtil.createJsonFile(user2, "user2.json");
		User2 user3 = new User2();
		user2.setEmail("eve.holt@reqres.in");
		FileUtil.createJsonFile(user3, "user3.json");
	}

	@Test()
	public void validatePostLogin() {
		apiCore = new ApiCore("/users", "staff.json", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 201);
		Reporter.log("PostLogin status code: " + testResponse.statusCode());
		Reporter.log("PostLogin response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validatePostCreateUser() {
		apiCore = new ApiCore("/users", "user.json", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 201);
		Reporter.log("PostCreateUsers status code: " + testResponse.statusCode());
		Reporter.log("PostCreateUsers response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validateSuccessfullPostRegister() {
		apiCore = new ApiCore("/register", "user2.json", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("PostRegister status code: " + testResponse.statusCode());
		Reporter.log("PostRegister response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validateUnsuccessfullPostRegister() {
		apiCore = new ApiCore("/register", "user3.json", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 400);
		Reporter.log("PostRegister status code: " + testResponse.statusCode());
		Reporter.log("PostRegister response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validateGetUsers() {
		apiCore = new ApiCore("/users", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUsers status code: " + testResponse.statusCode());
		Reporter.log("GetUsers response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validateGetUnknownUser() {
		apiCore = new ApiCore("/users/unknown", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 404);
		Reporter.log("GetUnknown status code: " + testResponse.statusCode());
		Reporter.log("GetUnknown response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validateGetUnknownList() {
		apiCore = new ApiCore("/unknown", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUnknownList code: " + testResponse.statusCode());
		Reporter.log("GetUnknownList response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validateGetUser() {
		apiCore = new ApiCore("/users/2", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUser with id=2 status code: " + testResponse.statusCode());
		Reporter.log("GetUser with id=2 response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validatePutUser() {
		apiCore = new ApiCore("/users/2", "user.json", Constants.REQ_RES_BASE_URI);
		testResponse = apiCore.put();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUser with id=2 status code: " + testResponse.statusCode());
		Reporter.log("GetUser with id=2 response body: " + testResponse.getBody().asPrettyString());
	}
}
