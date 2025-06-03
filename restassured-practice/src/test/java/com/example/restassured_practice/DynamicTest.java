package com.example.restassured_practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.payload.BasicsPaylod;
import com.restassured.payload.CommonMethod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicTest {
	
		@Test(dataProvider = "Data")
		public void addName (String name, String grade, String score) {
			RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
			String response = given().header("Content-Type", "application/json").body(BasicsPaylod.addStudent(name, grade, score))
			.when().post("/post").then().assertThat().statusCode(200).extract().response().asString();
			
			
			JsonPath js = CommonMethod.rawToJson(response);
			String getId = js.getString("id");
		}
		@DataProvider(name = "Data")
		public  Object[][] addData() {
			return new Object[][] {{"Chaeles Browb", "A", "98"},{"readic Browb", "B", "88"},{"jamesc Browb", "C", "28"}};
		}
		
		// we can call multiple data using static json file as 
		// new String(file.getAllByres(path.get("Json path")));
}
