package util;

import io.restassured.path.json.JsonPath;

public class JsonPathUtil {
	JsonPath jsonPath;
	
 	public JsonPathUtil(String jsonString) {
 		this.jsonPath = new JsonPath(jsonString);
	}
 	
 	public String getString(String path) {
		return jsonPath.getString(path);
	}
}
