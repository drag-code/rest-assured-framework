package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class SerializationUtil {

	public static <T> String serialize(T object) {
		return Jsoner.prettyPrint(Jsoner.serialize(object));
	}

	public static <T> T deserializeAsObject(String deserializable, Class<T> destinationClass) {
		JsonObject jsonObject;
		Mapper mapper = new DozerBeanMapper();
		T deserializedObject = null;
		try {
			jsonObject = (JsonObject) Jsoner.deserialize(deserializable);
			deserializedObject = mapper.map(jsonObject, destinationClass);
		} catch (JsonException e) {
			System.out.println(e.getMessage());
		}
		return deserializedObject;
	}

	public static String deserializeFromFileAsJsonString(String fileName) {
		String jsonString = "";

		try (FileReader fileReader = new FileReader(Constants.FILES_PATH + fileName)) {
			jsonString = ((JsonObject) Jsoner.deserialize(fileReader)).toJson();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (JsonException e) {
			System.out.println(e.getMessage());
		}

		return jsonString;
	}
}
