package pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	
	AddPlace p = new AddPlace();
	p.setAccuracy(50);
	p.setName("Princess Castle 3");
	p.setPhone_number("(+91) 983 893 3937");
	p.setAddress("Spiritual Landing place");
	p.setWebsite("https://www.google.com");
	p.setLanguage("French-IN");
	
	
// types is a list so we have to create a list object first
	p.setTypes(types);
	
	Response res = given().queryParam("key", "qaclick")
	.body()
	.when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response();
	
	String responseString = res.asString();
	System.out.println(responseString);
	}

}
