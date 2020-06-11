package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DynamicJson {
	
	
	@Test
	public void addBook() {
		RestAssured.baseURI ="http://216.10.245.166";
		
		String response = given().header("Content_Type","application/json")
		.body(payload.AddBook())
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		// dynamically build json payload with external data inputs
		// parameterize teh API Tests with multiple data sets
		// How to send static json files (payload) directly into Post Methods of Rest Assured
		
	}
	 

}
