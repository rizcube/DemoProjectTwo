package files;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

public class oAuthTest {
	
	public static void main (String[] args) 
	{
		// first hit https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=abcd			
					
		String url = "https://rahulshettyacademy.com/getCourse.php?state=abcd&code=4%2F0wGYWO4E8DqBgeIYnSqVPoPmJ2PuGn9kGqQo-IHPCznOGJdrqs8Xoclsn0dD6cSmBTWFMMNB3jv45gEtSViCNgc&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";
		
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
		
		
		String response = given().queryParam("access_token", accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		System.out.println(response);
		
	}

}
