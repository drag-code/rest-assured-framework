package pojo;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

public class Place implements Jsonable {
//	{
//	    "location": {
//	        "lat": -38.383494,
//	        "lng": 33.427362
//	    },
//	    "accuracy": 50,
//	    "name": "Frontline house",
//	    "phone_number": "(+91) 983 893 3937",
//	    "address": "29, side layout, cohen 09",
//	    "types": [
//	        "shoe park",
//	        "shop"
//	    ],
//	    "website": "http://google.com",
//	    "language": "French-IN"
//	}
	private Location location;
	private Integer accuracy;
	private String name;
	private String phoneNumber;
	private String address;
	private String[] types;
	private String website;
	private String language;
	
	

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Integer getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String toJson() {
		final StringWriter writable = new StringWriter();
		try {
			this.toJson(writable);
		} catch (final IOException e) {
		}
		return writable.toString();
	}
	public void toJson(Writer writable) throws IOException {
		final JsonObject json = new JsonObject();
		json.put("name", this.getName());
		json.put("location", this.getLocation());
		json.put("accuracy", this.getAccuracy());
		json.put("phone_number", this.getPhoneNumber());
		json.put("address", this.getAddress());
		json.put("types", this.getTypes());
		json.put("website", this.getWebsite());
		json.put("language", this.getLanguage());
		json.toJson(writable);
		
	}
	
}
