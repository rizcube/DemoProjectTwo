package files;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

public class oAuthTest {
	
	public static void main (String[] args) 
	{
		
		String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
		
		// first hit https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=abcd			
					
		String url = "https://rahulshettyacademy.com/getCourse.php?state=abcd&code=4%2F0wGr0q4CEZxdVcpoXgMjV-bou1f2zDutMZEo2xleC4F81pEwSBe13Sa7szHcSfJ87yi8Z2YzWFDliy86v-RPi38&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";
		
		String partialcode =url.split("code=")[1];
		String code = partialcode.split("&scope")[0];
		System.out.println("code is >"+code);
		
		
		
		String accessTokenResponse  =given().urlEncodingEnabled(false)
		.queryParams("code",code)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		// .expect().defaultParser(Parser.JSON) can be avoided if the response header is the Content-Type is application-json 
		GetCourse gc = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		//System.out.println(response);
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		// this return only the course on 1st index, how to find course if we don't know the index of the course.
		gc.getCourses().getApi().get(1).getCourseTitle();
		
		List<Api> apiCourses = gc.getCourses().getApi();
		System.out.println(apiCourses);
		
		for(int i=0; i<apiCourses.size();i++) {
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) 
			{
				System.out.println(apiCourses.get(i).getCourseTitle());
				System.out.println(apiCourses.get(i).getPrice());
			}
			
		}
		
		// Get the course names of WebAutomation
		ArrayList<String> a = new ArrayList<String>();  // here we have created an object for array class so that we can append in it using add method.
		List<WebAutomation> web = gc.getCourses().getWebAutomation();
		
		
		for (int j=0; j<web.size(); j++) 
		{	
			a.add(web.get(j).getCourseTitle());
		
		}
		List<String> expectedList = Arrays.asList(courseTitles);
		// this requires testng jar
		Assert.assertTrue(a.equals(expectedList));
		
		System.out.println("Expected List >" + expectedList);
		System.out.println("Actual List>" + a);
	}

}
