import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
 	public void sumOfCourses() 
	{
		int sum = 0;
		JsonPath js = new JsonPath(payload.CoursePrice()); 
		int count = js.getInt("courses.size()");
		for (int i=0; i<count; i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			sum = sum + amount;
			System.out.println("Total amount: " + amount);
			
		}
			System.out.println("sum is :" + sum);
			int purchaseAmount = js.get("dashboard.purchaseAmount");
			System.out.println(purchaseAmount);
			
	}

}
