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
			// without wrapping it in a variable
			System.out.println(js.getString("courses["+i+"].price").toString());
			// wrapping in a variable
			int price = js.getInt("courses["+i+"].price");
			System.out.println(price);
			
			
		}
		
		System.out.println("Print number of copies are sold by RPA");
		for (int i=0; i< count; i++) 
		{
		String courseTitles = js.get("courses["+i+"].title");
		if(courseTitles.equalsIgnoreCase("RPA")) 
			{
			// return copies sold
			int copies = js.get("courses["+ i +"].copies");
			System.out.println(copies);
			break;
			}
		}
		
		
	}

}
