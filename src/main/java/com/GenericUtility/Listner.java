package com.GenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseCase.BaseClass;

public class Listner implements ITestListener
{

	public void onTestStart(ITestResult result) {


	}

	public void onTestSuccess(ITestResult result) {


	}

	public void onTestFailure(ITestResult result) 
	{
		String data=result.getMethod().getMethodName();
		System.out.println(data+"------------Executing Listning---------------");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			File dest=new File("./com.VtigerApp/Screenshot./"+data+".png");
			FileUtils.copyFile(src,dest);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onTestFailedWithTimeout(ITestResult result) {


	}

	public void onStart(ITestContext context) {


	}

	public void onFinish(ITestContext context) {


	}

}
