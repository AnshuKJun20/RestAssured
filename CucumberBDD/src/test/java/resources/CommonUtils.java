package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonUtils {
	public static RequestSpecification res;
	public ResponseSpecification respc;

	public RequestSpecification requestSpecification() throws IOException {
		if(res == null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		res = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return res;
		}
		return res;

	}

	public ResponseSpecification responseSpecification() throws FileNotFoundException {
		respc = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		return respc;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\kumaria1\\Desktop\\RestAssured\\CucumberBDD\\src\\test\\java\\resources\\Constant.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
	

}
