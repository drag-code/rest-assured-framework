package testng;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import pojo.Staff;

public class TestJSONSimple {
	public Staff createStaff() {
		Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(38);
        staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
        @SuppressWarnings("unchecked")
		Map<String, BigDecimal> salary = new HashMap(){{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;
	}

	@Test(enabled = false)
	public void writeJson() throws IOException {
		Staff staff = createStaff();
		String json = Jsoner.serialize(staff);
		json = Jsoner.prettyPrint(json);
		System.out.println(json);
		
		try(FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\files\\staff.json")) {
			Jsoner.serialize(staff, fileWriter);
		}
	}
	
	@Test(enabled = false)
	public void writeJsonList() throws IOException {
		List<Staff> staffList = Arrays.asList(createStaff(), createStaff());
		
		try(FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\files\\staffList.json")) {
			Jsoner.serialize(staffList, fileWriter);
		}
	}
	
	@Test(enabled = false)
	public void JSONToObject() throws IOException, JsonException {
		try(FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\files\\staff.json")) {
			JsonObject deserializedJsonObject = (JsonObject) Jsoner.deserialize(fileReader);
			Mapper mapper = new DozerBeanMapper(); 
			Staff staff = mapper.map(deserializedJsonObject, Staff.class);
			System.out.println(staff);
			
		}
	}
	
	@Test()
	public void JSONArrayToObject() throws IOException, JsonException {
		try(FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\files\\staffList.json")) {
			JsonArray objects = Jsoner.deserializeMany(fileReader);
			Mapper mapper = new DozerBeanMapper();
			JsonArray oArray = (JsonArray) objects.get(0);
			List<Staff> staff = oArray
					.stream()
					.map(object -> mapper.map(object, Staff.class))
					.toList();
			System.out.println(staff);
		}
	}
}
