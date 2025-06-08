package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CompanyPojo;
import pojo.Geo;
import pojo.UserPojo;
import pojo.addressPojo;
import resources.CommonUtils;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import Payload.TestDataPayload;

public class AddEmployee extends CommonUtils {
	RequestSpecification res1;
	
	String resp1;
	
	TestDataPayload tp = new TestDataPayload();

	@Given("Add employee payload")
	public void add_employee_payload() throws IOException {
	
		res1 = given().spec(requestSpecification()).body(tp.addEmployeePayload());
		System.out.println("Request specification (res1) initialized: " + (res1 != null));
	}

	@When("users calls AddemployeeeApi with post http request")
	public void users_calls_addemployeee_api_with_post_http_request() throws FileNotFoundException {
		System.out.println("Is res1 null before POST? " + (res1 == null));
		// Use relative path here because baseUri is set in res
		resp1 = res1.when().post("/users").then().spec(responseSpecification()).extract().response().asString();

	}

	@Then("{string} of the API is {string}")
	public void of_the_api_is(String field_name, String expectedValue) {
	    if (field_name.equalsIgnoreCase("status")) {
	        // Compare HTTP response status code
	        int actualStatusCode = res1.when().post("/users").then().extract().statusCode();
	        Assert.assertEquals(String.valueOf(actualStatusCode), expectedValue);
	    } else {
	        JsonPath js = new JsonPath(resp1);
	        Assert.assertEquals(js.getString(field_name), expectedValue);
	    }
	}
}
