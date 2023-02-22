package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data_providers.LibraryProvider;
import io.restassured.response.Response;
import pojo.ApiCore;
import util.Constants;
import util.Payload;

public class LibraryTest {
	ApiCore apiCore;
	Response testResponse;

	@BeforeTest
	public void setup() {
		apiCore = new ApiCore(Constants.LIBRARY_BASE_URI);
	}

	@Test(enabled = true, dataProvider = "provideBooks", dataProviderClass = LibraryProvider.class)
	public void testAddBook(String isbn, String aisle) {
		apiCore.getCustomRequest().setJsonHeaders();
		apiCore.getCustomRequest().addBody(Payload.addBook(isbn, aisle));
		apiCore.getCustomRequest().setResource(Constants.LIBRARY_ADD_BOOK);
		apiCore.post().then().log().all();
	}

	@Test(enabled = false)
	public void testDeleteBook() {
		apiCore.getCustomRequest().setJsonHeaders();
		apiCore.getCustomRequest().addBody(Payload.deleteBook("aioahsa"));
		apiCore.getCustomRequest().setResource(Constants.LIBRARY_DELETE_BOOK);
		apiCore.delete().then().log().all();
	}

	@Test(enabled = false)
	public void testGetBook() {
		apiCore.getCustomRequest().setResource(Constants.LIBRARY_GET_BOOK);
		apiCore.getCustomRequest().addQueryParam("AuthorName", "John Doe");
		apiCore.get().then().log().all();
	}
}
