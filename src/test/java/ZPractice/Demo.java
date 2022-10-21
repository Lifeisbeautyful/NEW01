package ZPractice;

import org.testng.annotations.Test;

@Test
public class Demo 
{
	@Test(priority=-3)
	public void Createcustomer()
	{
		System.out.println("Creating a statment");
		int a=20/0;
		System.out.println(a);
    }
	
	@Test(priority=2,dependsOnMethods="Createcustomer")
	public void modifycustomer()
	{
		System.out.println("Creating a ment");
    }
	
	@Test(priority=1)
	public void deletecustomer()
	{
		System.out.println("Creating a state");
    }
}
