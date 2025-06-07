package ECommerce;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class EcomClass {
	public static void main(String[] args) {

		LoginPojo lp = new LoginPojo();
		lp.setUserEmail("postmail@gmail.com");
		lp.setUserPassword("Hello@12345");

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		RequestSpecification reqLogin = given().spec(req).body(lp);

		// Optional: Print raw response for debugging
		String responseString = reqLogin.when().post("/api/ecom/auth/login").then().extract().asString();
		System.out.println("Raw Response:\n" + responseString);

		// Now deserialize
		LoginResponse lps = reqLogin.when().post("/api/ecom/auth/login").then().extract().response()
				.as(LoginResponse.class);

		String token = lps.getToken();
		System.out.println("Message: " + lps.getMessage());
		String id = lps.getUserId();

		// Add to cART
		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();

		RequestSpecification reqAddProduct = given().log().all().spec(addProductBaseReq).param("productName", "Laptop")
				.param("productAddedBy", id).param("productCategory", "fashion").param("productSubCategory", "shirts")
				.param("productPrice", "11500").param("productDescription", "Lenova").param("productFor", "men")
				.multiPart("productImage", new File("C:\\Users\\kumaria1\\Documents\\OIP.jpg"));

		String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product").then().log().all()
				.extract().response().asString();
		JsonPath js = new JsonPath(addProductResponse);
		String productId = js.get("productId");

		// Create Order
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productId);

		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderDetailList.add(orderDetail);
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);

		RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);

		String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all()
				.extract().response().asString();
		System.out.println(responseAddOrder);

		// Delete Product

		RequestSpecification deleteProdBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();

		RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq).pathParam("productId",
				productId);

		String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}")
				.then().log().all().extract().response().asString();

		JsonPath js1 = new JsonPath(deleteProductResponse);

		Assert.assertEquals("Product Deleted Successfully", js1.get("message"));

	}
}
