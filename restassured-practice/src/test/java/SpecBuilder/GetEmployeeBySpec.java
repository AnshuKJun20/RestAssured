package SpecBuilder;

import static io.restassured.RestAssured.given;

import Serialization.CompanyPojo;
import Serialization.Geo;
import Serialization.UserPojo;
import Serialization.addressPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetEmployeeBySpec {
	public static void main(String[] args) {
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

		RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification respc = new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).build();

		RequestSpecification res1 = given().spec(res).body(pj);
		Response resp1 = res1.when().post("https://jsonplaceholder.typicode.com/users").then().spec(respc).extract()
				.response();
		String response = resp1.asString();
		System.out.println(response);
	}
}
