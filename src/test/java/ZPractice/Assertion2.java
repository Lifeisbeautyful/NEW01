package ZPractice;

import org.testng.Assert;
import org.testng.annotations.Test;



//This program for Assertion( Failed Testscripts)
public class Assertion2
{
	@Test
	public void createcustomerTest()
	{
		System.out.println("Step 01");
		System.out.println("Step 02");
		System.out.println("=======================================");
		Assert.assertEquals("A", "B");//Fails
		System.out.println("Step 03");
		System.out.println("Step 04");	
	}
	
	@Test
	public void modifyCustomertest()
	{
		System.out.println("=======================================");
		System.out.println("Step 01");
		System.out.println("Step 02");
		System.out.println("Step 03");
	}
}


		
	
	