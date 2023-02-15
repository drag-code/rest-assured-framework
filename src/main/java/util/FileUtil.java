package util;

import java.io.FileWriter;
import java.io.IOException;
import com.github.cliftonlabs.json_simple.Jsoner;

public class FileUtil {
	
	public static void createJsonFile(Object serializableData, String fileName) {
		try(FileWriter fileWriter = new FileWriter(Constants.FILES_PATH + fileName)) {
			Jsoner.serialize(serializableData, fileWriter);
		} catch (IOException e) {}
	}
}
