package DataProvider;

import org.testng.annotations.DataProvider;

public class DataproviserTest 
{
	//@Test(dataProvider="dataProvider_test")

	public void bookTicket(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest);
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";

		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";

		objArr[2][0]="Bangalore";
		objArr[2][1]="Mangalore";

		objArr[3][0]="Bangalore";
		objArr[3][1]="Mumbai";

		objArr[4][0]="Bangalore";
		objArr[4][1]="Kerala";

		return objArr;
	}

}


