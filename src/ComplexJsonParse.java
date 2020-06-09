import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		// Print no of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		// purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
	}

}
