package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
	@Test
	public void m1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals("A", "A");
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}
	
	@Test
	public void m2()
	{
		String expData = "Sumitha";
		String actData = "Janani";
		Assert.assertEquals(actData, expData); //-----> Assertion Fail
	}
	
	@Test
	public void m3()
	{
		String expData = "Sumitha";
		String actData = "Sumitha";
		Assert.assertEquals(actData, expData,"Assert Fail");
		System.out.println("Assert Pass");
		
	}
	
	@Test
	public void m4()
	{
		int expData = 10;
		int actData = 20;
		Assert.assertEquals(actData, expData, "Assert Fail");
		System.out.println("assert Pass");
	}
	
	@Test
	public void m5()
	{
		int expData = 10;
		int actData = 20;
		Assert.assertNotEquals(actData, expData,"Assert Equal");
		System.out.println("Assert not Equal");
	}
	
	@Test
	public void m6()
	{
		int expData = 20;
		int actData = 20;
		Assert.assertNotEquals(actData, expData,"Assert Equal");
		System.out.println("Assert not Equal");
	}
	
	@Test
	public void m7()
	{
		String expData = "Sumitha";
		String actData = "Sumitha";
		Assert.assertTrue(expData.equals(actData), "Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m8()
	{
		String expData = "Sumitha";
		String actData = "SumithA";
		Assert.assertTrue(expData.equals(actData), "Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m9()
	{
		String expData = "Sumitha";
		String actData = "Sumitha";
		Assert.assertFalse(expData.equals(actData), "Assert Equal");
		System.out.println("Assert not Equal");
	}
	
	@Test
	public void m10()
	{
		String expData = "Sumitha";
		String actData = "SumithA";
		Assert.assertFalse(expData.equals(actData), "Assert Equal");
		System.out.println("Assert not Equal");
	}
	
	@Test
	public void m12()
	{
		String data = "Sumitha";
		Assert.assertNull(data,"Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m13()
	{
		String data = null;
		Assert.assertNull(data,"Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m14()
	{
		String data = null;
		Assert.assertNotNull(data,"Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m15()
	{
		String data = "Sumitha";
		Assert.assertNotNull(data,"Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m16()
	{
		int expData = 20;
		int actData = 20;
		Assert.assertSame(actData, expData,"Assert not Equal");
		System.out.println("Assert Equal");
	}
	
	@Test
	public void m17()
	{
		int expData = 20;
		int actData = 10;
		Assert.assertSame(actData, expData,"Assert not Equal");
		System.out.println("Assert Equal");
	}
	
	@Test
	public void m18()
	{
		int expData = 20;
		int actData = 20;
		Assert.assertNotSame(actData, expData,"Assert Equal");
		System.out.println("Assert not Equal");
	}
	
	@Test
	public void m19()
	{
		int expData = 20;
		int actData = 10;
		Assert.assertNotSame(actData, expData,"Assert Equal");
		System.out.println("Assert not Equal");
	}
	
	@Test
	public void m20()
	{
		Assert.fail("I am Failing the assertion");
	}
}
