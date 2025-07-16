package TestNG_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Sample {
	
//	@Ignore
	@Test(priority = 2, invocationCount = 0)
	public void createProduct()
	{
		System.out.println("Product is Created");
	}
	
	@Test(priority = 1, enabled = true,dependsOnMethods = "createProduct")
	public void modifyProduct()
	{
		System.out.println("Product is Modified");
	}
	
	@Test(priority = 0,dependsOnMethods = {"createProduct","modifyProduct"})
	public void deleteProduct()
	{
		System.out.println("Product is Deleted");
	}

}
