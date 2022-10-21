package com.GenericUtility;

import java.util.Random;

public class JavaUtility
{
		/**
		 * 
		 * @return
		 * @author Deepak
		 */
		public int getRanDomNum()
		{
			Random ran=new Random();
			int RanNum=ran.nextInt(1000);
			return RanNum;
		}
	

}


