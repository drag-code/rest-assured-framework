package pojo;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

public class Location implements Jsonable {
	private BigDecimal lat;
	private BigDecimal lng;
	
	
	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
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
		json.put("lat", this.getLat());
		json.put("lng", this.getLng());
		json.toJson(writable);
		
	}
}
