package com.restassured.payload;
import io.restassured.path.json.*;

public class CommonMethod {
	

	public static JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
}
