package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
		//Invocation count-->Executing same method multiple time with with same set of data
		//Data Provider--> executing same method multiple time with different set of data
		
		@Test(dataProvider="getData")
		public void bookTickets(String src, String dest, int NumPeop)
		{
			System.out.println("Book Tickets from "+src+"to "+dest+". Total Number of people: "+NumPeop);
		}	
		
		@DataProvider
		public Object[][] getData()
		{
			Object[][] obj = new Object[3][3];
			
			obj[0][0] = "Banglore";
			obj[0][1] = "Goa";
			obj[0][2]= 2;
			
			obj[1][0] = "Chennai";
			obj[1][1] = "Mumbai";
			obj[1][2] = 5;
			
			obj[2][0] = "Delhi";
			obj[2][1] = "Mysore";
			obj[2][2] = 5;
			
			return obj;
			
		}

}
