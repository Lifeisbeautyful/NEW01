package com.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

import Ipathconstant.IpathConstant;
public class FileUtility {
	
	/**
	 * 
	 * @param Key
	 * @param return 
	 * @throws Throwable
	 * @author adminDeepak
	 */
	
	//Property file
	public String getPropertyKeyValue(String Key) throws Throwable 
	{
		
		FileInputStream f=new FileInputStream(IpathConstant.PROPERTYFILE_PATH1);
		//FileInputStream f=new FileInputStream("./Vtiger.properties");
		Properties p=new Properties();
		p.load(f);
		String value=p.getProperty(Key);
		return value;
	}
}

//.....................................................................................................................................




