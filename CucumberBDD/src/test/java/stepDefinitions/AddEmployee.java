package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CompanyPojo;
import pojo.Geo;
import pojo.UserPojo;
import pojo.addressPojo;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class AddEmployee {
    RequestSpecification res1;
    RequestSpecification res;
    Response resp1;
    ResponseSpecification respc;

    @Given("Add employee payload")
    public void add_employee_payload() {
        UserPojo pj = new UserPojo();
        addressPojo ad = new addressPojo();
        Geo g = new Geo();
        CompanyPojo c = new CompanyPojo();

        ad.setCity("Pune");
        ad.setStreet("3rd lane1");
        ad.setSuite("101");
        ad.setzipcode("109099");

        g.setLat("32.89");
        g.setLng("76.65");

        c.setBs("12");
        c.setCatchPhrase("Not bull");
        c.setName("Adsk");

        ad.setGeo(g);
        pj.setAddress(ad);
        pj.setEmail("ak@gmail.com");
        pj.setId("2");
        pj.setName("Eden");
        pj.setPhone("9938543890");
        pj.setWebsite("anc@ac.in");
        pj.setUsername("kk123");

        // Initialize base request spec with base URI and content type
        res = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();

        // Initialize response spec expecting 201 status and JSON content type
        respc = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();

        // Prepare the request with the payload
        res1 = given().spec(res).body(pj);

        System.out.println("Request specification (res1) initialized: " + (res1 != null));
    }

    @When("users calls AddemployeeeApi with post http request")
    public void users_calls_addemployeee_api_with_post_http_request() {
        System.out.println("Is res1 null before POST? " + (res1 == null));
        // Use relative path here because baseUri is set in res
        resp1 = res1.when().post("/users").then().spec(respc).extract().response();

        System.out.println("Response body: " + resp1.asString());
        System.out.println("Response status code: " + resp1.getStatusCode());
    }

    @Then("the API call is success the status code {int}")
    public void the_api_call_is_success_the_status_code(Integer expectedStatusCode) {
        // Compare status code as integer, not as string
        Assert.assertEquals(resp1.getStatusCode(), expectedStatusCode.intValue(),
                "Status code does not match!");
    }
}
