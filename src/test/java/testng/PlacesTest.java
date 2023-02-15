package testng;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojo.ApiCore;
import pojo.Location;
import pojo.Place;
import util.Constants;
import util.FileUtil;

public class PlacesTest {

	ApiCore apiCore;
	Response testResponse;

	@BeforeTest
	public void setup() {
		Place place = new Place();
		Location location = new Location();
		location.setLat(new BigDecimal(-38.383494));
		location.setLng(new BigDecimal(33.427362));
		place.setAccuracy(50);
		place.setAddress("29, side layout, cohen 09");
		place.setLanguage("French-IN");
		place.setLocation(location);
		place.setName("Frontline house");
		place.setPhoneNumber("(+91) 983 893 3937");
		place.setTypes(new String[] {"shoe park", "shop"});
		place.setWebsite("http://google.com");
		FileUtil.createJsonFile(place, "place.json");
	}

	@SuppressWarnings("serial")
	@Test()
	public void validatePostAddPlace() {
		apiCore = new ApiCore("/maps/api/place/add/json", "place.json", Constants.PLACES_BASE_URI);
		testResponse = apiCore.get(new HashMap<String, String>(){{
			put("key", Constants.PLACES_KEY);
		}});
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("PostAddPlace status code: " + testResponse.statusCode());
		Reporter.log("PostAddPlace response body: " + testResponse.getBody().asPrettyString());
	}
}
