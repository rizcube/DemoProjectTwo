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
	
	
		// print Title of the first course
		String title = js.getString("courses[0].title");
		System.out.println(title);
	
	
		//print title and price for each course available in the json
		
		for(int i=0; i<count; i++) {
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(courseTitles);
		}
		
	}

}
