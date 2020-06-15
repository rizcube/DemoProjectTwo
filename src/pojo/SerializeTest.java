package pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	
	Response res = given().queryParam("key", "qaclick")
	.body("{\n" + 
			"  \"location\": {\n" + 
			"    \"lat\": -38.383494,\n" + 
			"    \"lng\": 33.427362\n" + 
			"  },\n" + 
			"  \"accuracy\": 50,\n" + 
			"  \"name\": \"Princess Castle 3\",\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
			"  \"address\": \"Spiritual Landing place\",\n" + 
			"  \"types\": [\n" + 
			"    \"shoe park\",\n" + 
			"    \"shop\"\n" + 
			"  ],\n" + 
			"  \"website\": \"http://google.com\",\n" + 
			"  \"language\": \"French-IN\"\n" + 
			"}")
	.when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response();
	
	String responseString = res.asString();
	System.out.println(responseString);
	}

}
