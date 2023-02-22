package util;

public class Payload {
	public static String addBook(String isbn, String aisle) {
		return "{ \r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Rest Assured\", \r\n"
				+ "\r\n"
				+ "\"isbn\":\"" + isbn + "\", \r\n"
				+ "\r\n"
				+ "\"aisle\":\"" + aisle + "\", \r\n"
				+ "\r\n"
				+ "\"author\":\"John Doe\" \r\n"
				+ "\r\n"
				+ "}";
	}
	
	public static String deleteBook(String id) {
		return  "{ \r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "\"ID\" : \"" + id + "\" \r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "}";
	}
}
