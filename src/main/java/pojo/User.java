package pojo;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

public class User implements Jsonable {
	private String name;
	private String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", job=" + job + "]";
	}

	public String toJson() {
		final StringWriter writable = new StringWriter();
		try {
			this.toJson(writable);
		} catch (final IOException e) {
			System.out.println(e.getMessage());
		}
		return writable.toString();
	}

	public void toJson(Writer writable) throws IOException {
		final JsonObject json = new JsonObject();
		json.put("name", this.getName());
		json.put("job", this.getJob());
		json.toJson(writable);
	}

}
