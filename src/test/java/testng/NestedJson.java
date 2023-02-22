package testng;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

//[OK] 1. Print No of courses returned by API 
//
//[OK]  2.Print Purchase Amount
//
//[OK]  3. Print Title of the first course
//
//[OK]  4. Print All course titles and their respective Prices
//
//[OK]  5. Print no of copies sold by RPA Course
//
//[OK]  6. Verify if Sum of all Course prices matches with Purchase Amount

public class NestedJson {
	
	String payload = "{\r\n" + 
			"  \"dashboard\": {\r\n" + 
			"    \"purchaseAmount\": 1162,\r\n" + 
			"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
			"  },\r\n" + 
			"  \"courses\": [\r\n" + 
			"    {\r\n" + 
			"      \"title\": \"Selenium Python\",\r\n" + 
			"      \"price\": 50,\r\n" + 
			"      \"copies\": 6\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"title\": \"Cypress\",\r\n" + 
			"      \"price\": 40,\r\n" + 
			"      \"copies\": 4\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"title\": \"RPA\",\r\n" + 
			"      \"price\": 45,\r\n" + 
			"      \"copies\": 10\r\n" + 
			"    },\r\n" + 
			"     {\r\n" + 
			"      \"title\": \"Appium\",\r\n" + 
			"      \"price\": 36,\r\n" + 
			"      \"copies\": 7\r\n" + 
			"    }\r\n" + 
			"    \r\n" + 
			"    \r\n" + 
			"    \r\n" + 
			"  ]\r\n" + 
			"}\r\n" + 
			"";

	@Test
	public void validateNumberOfCoursesReturned() {
		JsonPath jsonPath = new JsonPath(payload);
		Integer courseCount = jsonPath.getInt("courses.size()");
		assertEquals(courseCount, 4);
	}
	
	@Test
	public void printPurchaseAmount() {
		JsonPath jsonPath = new JsonPath(payload);
		Integer purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
		System.out.println("PURCHASE AMOUNT: " + purchaseAmount);
	}
	
	@Test
	public void prinnTitleOfFirstCourse() {
		JsonPath jsonPath = new JsonPath(payload);
		String firstCourseTitle = jsonPath.getString("courses.get(0).title");
		System.out.println("FIRST COURSE TITLE: " + firstCourseTitle);
	}
	
	@Test
	public void prinnAllCoursesTitlesAndPrices() {
		JsonPath jsonPath = new JsonPath(payload);
		int coursesCount = jsonPath.getInt("courses.size()");
		for (int i = 0; i < coursesCount; i++) {
			String title = jsonPath.getString("courses.get(" + i + ").title");
			Integer price = jsonPath.getInt("courses.get(" + i + ").price");
			System.out.println(title + " - $" + price);
		}
	}
	
	@Test
	public void printNumberOfCopiesSoldByRPACourse() {
		JsonPath jsonPath = new JsonPath(payload);
		int coursesCount = jsonPath.getInt("courses.size()");
		int copiesSold = 0;
		for (int i = 0; i < coursesCount; i++) {
			String title = jsonPath.getString("courses.get(" + i + ").title");
			if (title.equals("RPA")) {
				copiesSold = jsonPath.getInt("courses.get(" + i + ").copies");
				break;
			}
		}
		System.out.println("COPIES SOLD BY RPA: " + copiesSold);
	}
	
	@Test
	public void verifyIfSumOfAllPricesMatchesPurchaseAmount() {
		JsonPath jsonPath = new JsonPath(payload);
		Integer expectedPurchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
		int coursesCount = jsonPath.getInt("courses.size()");
		int actualPurchaseAmount = 0;
		for (int i = 0; i < coursesCount; i++) {
			Integer price = jsonPath.getInt("courses.get(" + i + ").price");
			Integer copies = jsonPath.getInt("courses.get(" + i + ").copies");
			actualPurchaseAmount += copies * price; 
		}
		System.out.println("ACTUAL PURCHASE AMOUNT: " + actualPurchaseAmount);
		assertEquals(actualPurchaseAmount, expectedPurchaseAmount);
	}
}
