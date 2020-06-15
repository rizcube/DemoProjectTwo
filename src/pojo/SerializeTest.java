package pojo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	given().queryParam("key", "qaclick")
	.body(arg0)
	.when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response();
	
	}

}
