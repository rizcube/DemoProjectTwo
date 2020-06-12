package files;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	@Test
	public void addBook() throws IOException 
	{
		RestAssured.baseURI ="http://216.10.245.166";
		
		String response = given().header("Content_Type","application/json")
		.body(GeneratesStringFromResource("/Users/rizcube/eclipse-workspace/DemoProjectTwo/src/files/AddBookDetails.json"))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		
		// dynamically build json payload with external data inputs
		// parameterize teh API Tests with multiple data sets
		// How to send static json files (payload) directly into Post Methods of Rest Assured
		// lecture 35
	}
	 public static String GeneratesStringFromResource(String path) throws IOException {
		 return new String(Files.readAllBytes(Paths.get(path)));
	 }
	
}
