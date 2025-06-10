package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CompanyPojo;
import pojo.Geo;
import pojo.UserPojo;
import pojo.addressPojo;
import resources.APIEndpoint;
import resources.CommonUtils;
import Payload.TestDataPayload;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

public class AddEmployee extends CommonUtils {

    RequestSpecification res1;
    Response response;
    String resp1;

    TestDataPayload tp = new TestDataPayload();

    @Given("Add employee payload")
    public void add_employee_payload() throws IOException {
        res1 = given().spec(requestSpecification()).body(tp.addEmployeePayload());
        System.out.println("Request specification (res1) initialized: " + (res1 != null));
    }

    @When("users calls {string} with {string} http request")
    public void users_calls_http_method(String endpoint, String method) throws IOException {
        users_calls_http_method_with_param(endpoint, method, null);
    }

    @When("users calls {string} with {string} http request and parameter {string}")
    public void users_calls_http_method_with_param(String endpoint, String method, String param) throws IOException {
        String url = APIEndpoint.fromString(endpoint).getPath();

        // Replace placeholders like {id} with actual param if present
        if (param != null && url.contains("{id}")) {
            url = url.replace("{id}", param);
        }
        if (res1 == null) {
            res1 = given().spec(requestSpecification());
        }

        switch (method.toUpperCase()) {
            case "POST":
                response = res1.when().log().all().post(url);
                break;
            case "GET":
                response = res1.when().log().all().get(url);
                break;
            case "PUT":
                response = res1.when().log().all().put(url);
                break;
            case "PATCH":
                response = res1.when().log().all().patch(url);
                break;
            case "DELETE":
                response = res1.when().log().all().delete(url);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }
    
    @Then("verify user is added to the respective {string}")
    public void verify_user_is_added(String param) throws IOException {
        System.out.println(">> Inside: verify_user_is_added with param = " + param);
        users_calls_http_method_with_param("GET_USER_BY_ID", "get", param);
    }


    @Then("{string} of the API is {string}")
    public void of_the_api_is(String fieldName, String expectedValue) throws FileNotFoundException {
        // Validate using response spec (status code + content-type)
        response.then().spec(responseSpecification(expectedValue));

        // Extract the body only after verifying response
        resp1 = response.asString();
        System.out.println("Response body: " + resp1);

        if (!fieldName.equalsIgnoreCase("status")) {
            JsonPath js = new JsonPath(resp1);
            String actualFieldValue = js.getString(fieldName);
            System.out.println("Actual status code: " + response.getStatusCode());
            Assert.assertEquals(actualFieldValue, expectedValue, "Mismatch in response body field value");
        }
    }

}
