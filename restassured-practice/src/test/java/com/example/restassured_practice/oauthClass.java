package com.example.restassured_practice;

import static io.restassured.RestAssured.given;

import com.restassured.payload.CommonMethod;

import io.restassured.path.json.JsonPath;

public class oauthClass {
	public static void main(String[] args) {
		String token = given()
				.formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", " erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(token);
		JsonPath js = CommonMethod.rawToJson(token);
		String access_token = js.getString("access_token");

		String response = given().queryParam("access_token", access_token).log().all().when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		System.out.println(response);
	}
}
