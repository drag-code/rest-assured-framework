package pojo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import io.restassured.response.Response;
import util.Constants;
import util.SerializationUtil;

public class ApiCore {

	public Response PostLogin(String fileName, String resource) {
		Response response = null;
		CustomResponse customResponse = null;
		
		try (FileReader fileReader = new FileReader(Constants.FILES_PATH + "\\" + fileName)) {
			String body = SerializationUtil.deserializeFromFileAsJsonString(fileReader);
			customResponse = new CustomResponse(resource, body);
			response = customResponse.getResponseFromPost();
		} catch (FileNotFoundException e) {} 
		catch (IOException e) {}

		return response;
	}
}
