package com.example.restassured_practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import com.restassured.payload.BasicsPaylod;

import static io.restassured.RestAssured.*;

public class Basics {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://postman-echo.com";

		String response = given().queryParam("search", "books").header("x-demo-header", "test-header-value")
				.header("Content-Type", "application/json").body(BasicsPaylod.AddPlace()).when().post("/post").then()
				.assertThat().statusCode(200).body("args.search", equalTo("books")).extract().response().asString();
		System.out.println("This is response=>" + response);

		JsonPath js = new JsonPath(response);
		String title = js.getString("data.title");
		System.out.println(title + "====");

		// update author

		String response2 = given().queryParam("search", "books").header("x-demo-header", "test-header-value")
				.header("Content-Type", "application/json").body(BasicsPaylod.updateAuthor()).when().put("/put").then()
				.assertThat().statusCode(200).extract().response().asString();

		System.out.println(response2+"'''''''''''''");
		
		// get author

		String respone3 = given().queryParam("search", "books").queryParam("title", "API learning").when()
				.get("/get").then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(respone3+"--------");

	}

}
