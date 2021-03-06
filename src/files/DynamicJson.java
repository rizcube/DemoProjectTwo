package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicJson {
	
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String isle) 
	{
		RestAssured.baseURI ="http://216.10.245.166";
		
		String response = given().header("Content_Type","application/json")
		.body(payload.Addbook(isbn, isle))
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
	
@DataProvider(name="BooksData")
public Object[][] getData() 
{
	// array- collection of elements
	// multidimensional array - collection of arrays
	return new Object[][] {{"XYZ11","0988"},{"XYZ22","0977"},{"XYZ33","0966"}};
}
	
	 

}
