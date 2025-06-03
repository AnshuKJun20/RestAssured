package Serialization;

import static io.restassured.RestAssured.given;

public class GetEmployee {

	public static void main(String[] args) {
		UserPojo response = given().when().get("https://jsonplaceholder.typicode.com/users/1").then().extract().response()
				.as(UserPojo.class);
		String id = response.getId();
		String email = response.getEmail();
		CompanyPojo company = response.getCompany();
		addressPojo add = response.getAddress();
		System.out.println(id+", "+email+", "+company+", "+add);
	}
}
