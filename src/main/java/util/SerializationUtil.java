package util;

import java.io.Reader;

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
			
		}
		return deserializedObject;
	}
	
	public static String deserializeFromFileAsJsonString(Reader readableDeserializable) {
		String jsonString = "";
		try {
			jsonString = ((JsonObject) Jsoner.deserialize(readableDeserializable)).toJson();
		} catch (JsonException e) {
		}
		
		return jsonString;
	}
}
