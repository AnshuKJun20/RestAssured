package com.restassured.payload;

public class BasicsPaylod {
	
	public static String AddPlace() {
		return "{\r\n"
				+ "  \"title\": \"Learn API Testing\",\r\n"
				+ "  \"author\": \"OpenAI\",\r\n"
				+ "  \"published\": true,\r\n"
				+ "  \"rating\": 4.8\r\n"
				+ "}";
	}
	
	public static String updateAuthor() {
		return "{\r\n"
				+ "  \"title\": \"API learning\",\r\n"
				+ "  \"author\": \"Author Microsoft\"\r\n"
				+ "}";
	}
	
	public static String addStudent(String name, String grade, String score) {
		String payload = 
				"{\r\n"
				+ "  \"name\": \""+name+"\",\r\n"
				+ "  \"grade_level\": "+grade+",\r\n"
				+ "  \"math_score\": "+score+",\r\n"
				+ "  \"english_score\": 90,\r\n"
				+ "  \"science_score\": 88,\r\n"
				+ "  \"attendance_pct\": 94.5\r\n"
				+ "}";
		return payload;
	}

}
