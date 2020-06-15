package pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	
	AddPlace p = new AddPlace();
	
	
	Response res = given().queryParam("key", "qaclick")
	.body()
	.when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response();
	
	String responseString = res.asString();
	System.out.println(responseString);
	}

}
