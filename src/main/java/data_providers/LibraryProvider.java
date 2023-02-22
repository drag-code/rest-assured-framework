package data_providers;

import org.testng.annotations.DataProvider;

public class LibraryProvider {

	@DataProvider
	public String[][] provideBooks() {
		String data[][] = new String[][] { { "ISBN1", "AISLE1" }, { "ISBN2", "AISLE2" } };

		return data;
	}
}
