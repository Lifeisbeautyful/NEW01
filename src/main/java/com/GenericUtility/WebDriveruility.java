package com.GenericUtility;

import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriveruility
{
	//Maximize a Window of a Browser
	/**
	* To maximize a Window of a Browser
	* @param driver
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
//.......................................................................................................................................................	
	
	//Enter a URL of WebSite
	/**
    * To Enter a URL of WebSite
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getURL(WebDriver driver,String url) throws Throwable
	{
		driver.get(url);
	}	
	
//......................................................................................................................................................	

	//Thread.sleep
	/**
	* wait for page to load
	* @param driver
	* @author adminDeepak
	* @throws Throwable
	*/
	public void sleep(WebDriver driver) throws Throwable
	{
	     Thread.sleep(1000);
	}
//.......................................................................................................................................................	
	
	//ImplicitlyWait
	/**
	 * wait for page to load
	 * @param driver
	 * @author adminDeepak
	 */
	public void pageToLoadImplicitly(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		
//.......................................................................................................................................................	
	
	//ExplicitlyWait for Element to be located.
	/**
	 * wait for page to load 
	 * @param by
	 * @param driver
	 * @author adminDeepak
	 */
	public void pageToLoadExplicitly(WebDriver driver, WebElement Element) throws Throwable
	{
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	}

//......................................................................................................................................................	
	
	//Explicitly wait for Page to be loaded & available in GUI
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}

//......................................................................................................................................................	

	//FluentWait
	/**
	 * used to wait for element to be clickAble in GUI and check for specific element for every 500 milliseconds
	 * @author adminDeepak
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void waitforElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		@SuppressWarnings("rawtypes")
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
//......................................................................................................................................................	

	//Navigate, Back, Forward, refresh a BroeSer
	/**
	 * To Navigate, Back, Forward, refresh a browser
	 * @param 
	 * @author adminDeepak
	 * @throws Throwable 
	 */
	public void navigateTo(WebDriver driver,String url) throws Throwable
	{
		driver.navigate().to(url);
	}
	
	public void navigatBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public void navigateForword(WebDriver driver)
	{
	    driver.navigate().forward();
	}
	
	public void navigateRefresh(WebDriver driver)
	{
	    driver.navigate().refresh();
	}
	
//......................................................................................................................................................	

	//To delete all the cookies in the Browser
	/**
	* To delete all the cookies in the Browser
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void deleteAllCookies(WebDriver driver) throws Throwable
	{
		driver.manage().deleteAllCookies();
	}
		
//......................................................................................................................................................	

	//Close a Browser
	/**
	 * To close a Browser
	 * @param 
	 * @author adminDeepak
	 * @throws Throwable 
	 */
	public void close(WebDriver driver) throws Throwable
	{
		driver.close();
	}
	
//......................................................................................................................................................	

	//Quit a Browser
	/**
	* To close a Browser
	* @param 
	* @author adminDeepak
    * @throws Throwable 
	*/
	public void quit(WebDriver driver) throws Throwable
	{
			driver.quit();
	}
		
//......................................................................................................................................................	

	//To print a Title of the WebSite
	/**
	* To print a title of the WebSite
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getTitleOfWebSite2Print(WebDriver driver) throws Throwable
	{
		String Title=driver.getTitle();
		System.out.println();
		System.out.println("Title of a WebSite is = " + Title);
	}
	
//......................................................................................................................................................	
	
	//Verifying a Title of the WebSite and print by Contains method
	/**
	* To verifying a title of the WebSite to print
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getTitleWebSite2VerifyC(WebDriver driver,String data) throws Throwable
	{
		String Title=driver.getTitle();
		if(Title.contains(data))
		{
			System.out.println();
			System.out.println("Title of a website is verified");
		}
		else
		{
			System.out.println();
			System.out.println("Title of a website is not verified");
		}
		System.out.println();
		System.out.println("Title of a WebSite is = " + Title);
	}
			
//......................................................................................................................................................	
	
	//Verifying a Title of the WebSite and print by Equals method
	/**
	* To verifying a title of the WebSite to print
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getTitleWebSite2VerifyE(WebDriver driver,String data) throws Throwable
	{
		String Title=driver.getTitle();
		if(Title.equals(data))
		{
			System.out.println();
			System.out.println("Title of a website is verified");
		}
		else
		{
			System.out.println();
			System.out.println("Title of a website is not verified");
		}
		System.out.println();
		System.out.println("Title of a WebSite is = " + Title);
	}
		
//......................................................................................................................................................	

	//Verifying a Title of WebPage and print by Equals method
	/**
	* To verifying a title of WebPage
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getTitleWP2VarifyE(WebDriver driver,String data,WebElement Element) throws Throwable
	{
		String S10=Element.getText();
		if(S10.equals(data))
		{
			System.out.println();
			System.out.println("Title is verified");
		}
		else
		{
			System.out.println();
			System.out.println("Title is not verified");
		}
		System.out.println();
		System.out.println("Title is = " + S10 );
	}
			
//......................................................................................................................................................	

	//Verifying a Title of WebPage and print by Contains method
	/**
	* To verifying a title of WebPage
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getTitleWP2VarifyC(WebDriver driver,String data,WebElement Element) throws Throwable
	{
		String S10=Element.getText();
		if(S10.contains(data))
		{
			System.out.println();
			System.out.println("Title is verified");
		}
		else
		{
			System.out.println();
			System.out.println("Title is not verified");
		}
		System.out.println();
		System.out.println("Title is = " + S10);
	}
				
//......................................................................................................................................................	

	//To print a URL of the WebSite
	/**
	* To print a title of the WebSite
	* @param 
	* @author adminDeepak
	* @throws Throwable 
	*/
	public void getURL2Print(WebDriver driver) throws Throwable
	{
		String URL=driver.getCurrentUrl();
		System.out.println();
		System.out.println("URL of a WebSite is = " + URL);
	}
			
//......................................................................................................................................................	

	//To get a Attribute value(Text) of WebElement
	/**
	*To get a Attribute value(Text)
	*@param driver
	*/
	public void getAttribute(WebDriver driver,WebElement Element)
	{
			
		String s10=Element.getAttribute("value");
		System.out.println();
		System.out.println("Attribute value is = " + s10);
	}

//..............................................................................................................................................................

	//To get a Text of WebElement
	/**
	*To get a Text
	*@param driver
	*/
	public void getText(WebDriver driver,WebElement Element)
	{
				
		String s10=Element.getText();
		System.out.println();
		System.out.println("Text is = " + s10);
	}

//..............................................................................................................................................................

	//To remove text present in the text box by using KeyBoard Actions
	/**
	*TO remove Text by using KeyBoard Actions
	*@param driver
	*/
	public void removeByCD(WebDriver driver,WebElement Element)
	{	
		Element.sendKeys(Keys.CONTROL+"a");
		Element.sendKeys(Keys.DELETE);
	}

//..............................................................................................................................................................

	//To remove text present in the text box by using KeyBoard Actions
	/**
	*To remove Text by using BackSpace
	*@param driver
	*/
	public void removeByBackSpace(WebDriver driver,WebElement Element)
	{	
		String S=Element.getAttribute("value");
		int count=S.length();
		for(int i=1;i<=count;i++)
		{
			Element.sendKeys(Keys.BACK_SPACE);
		}
	}

//..............................................................................................................................................................

//To Verify whether button is enabled or not
	/**
	*To Verify whether button is enabled or disabled
	*@param driver
	*/
	public void isEnabled(WebDriver driver,WebElement Element)
	{	
		if(Element.isEnabled())
		{
			System.out.println();
			System.out.println("Button is enabled");
		}
		else
		{
			System.out.println();
			System.out.println("Button is disabled");
		}
	}

//..............................................................................................................................................................

	//To Verify LOGO of WebSite
	/**
	*To Verify LOGO of WebSite
	*@param driver
	*/
	public void isDisplayed(WebDriver driver,WebElement Element)
	{	
		if(Element.isDisplayed())
		{
			System.out.println();
			System.out.println("Logo is displayed");
		}
		else
		{
			System.out.println();
			System.out.println("Logo is not displayed");
		}
	}

//..............................................................................................................................................................

	//To Verify Fields is selected or not
	/**
	*To Verify LOGO of WebSite
	*@param driver
	*/
	public void isSelected(WebDriver driver,WebElement Element)
	{	
		if(Element.isSelected())
		{
			System.out.println();
			System.out.println("field is selected");
		}
		else
		{
			System.out.println();
			System.out.println("field is not selected");
		}
	}
	
//..............................................................................................................................................................

	//Handling ListBox by Index
	/**
	 * To select a option in ListBox
	 * @param element
	 * @param index
	 * @author adminDeepak
	 */
	public void selectOptionsByIndex(WebElement Element,int index)
	{
		Select s=new Select(Element);
		s.selectByIndex(index);
	}
		
//......................................................................................................................................................	
		
    //Handling ListBox by Text
	/**
	 * To select a option in ListBox
	 * @param element
	 * @param text
	 * @author adminDeepak
	 */
	public void selectOptionByText(WebElement Element,String text)
	{
		Select s=new Select(Element);
		s.selectByVisibleText(text);
	}	
		
//......................................................................................................................................................	
	
	//Handling ListBox by Value
	/**
	 * To select a option in ListBox
	 * @param element
	 * @param text
	 * @author adminDeepak
	 */
	public void selectOptionsByValue(WebElement Element,String value)
	{
		Select s=new Select(Element);
		s.selectByValue(value);
	}

//......................................................................................................................................................	

	//Handling ListBox(To verify whether the listbox is single select or multiselect)
		/**
		 * To verify whether the listbox is single select or multiselect
		 * @param element
		 * @param text
		 * @author adminDeepak
		 */
		public void isMultiple(WebElement Element,String value)
		{
			Select S=new Select(Element);
			boolean v=S.isMultiple();
			System.out.println();
			System.out.println("is it multiselected = " + v);
		}

//......................................................................................................................................................	

	//Handling ListBox(To count the number of options in th listBox)
	/**
	* To verify whether the listbox is single select or multiselect
	* @param element
	* @param text
    * @author adminDeepak
	*/
	public void countOptions(WebElement Element,String value)
	{
		Select S=new Select(Element);
		Collection<WebElement> L=S.getOptions();
		int count=L.size();
		System.out.println();
		System.out.println("Number of options present in the listBox is = " + count);
	}

//......................................................................................................................................................	

	//Mouse actions(Drop Down Menu)
	/**
	 * used to place mouse cursor over a specified element
	 * @param driver
	 * @param element
	 * @author adminDeepak
	 */
	public void moveOverOnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}

//......................................................................................................................................................	
		
	//Right Click Action of Mouse
	/**
	 *to right click  on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions a= new Actions(driver);
		a.contextClick(elemnet).perform();
	}	
		
//......................................................................................................................................................	
		
	//Drag and Drop Action of Mouse
	/**
	 *to Drag and Drop on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void dragAndDrop(WebDriver driver , WebElement source,WebElement target)
	{
		Actions a= new Actions(driver);
		a.dragAndDrop(source,target).perform();
	}

//.......................................................................................................................................................		

	//Double click action of Mouse
	/**
	 *to double click on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void Doubleclick(WebDriver driver)
	{
		Actions a= new Actions(driver);
		a.doubleClick().perform();
	}

//.......................................................................................................................................................		
	
	//driver.getWindowhandle()(Child Windows PopUp - 1)
	/**
	*To get a session Id of the Window(ADDRESS)
	* @param driver
	* @author adminDeepak
	*/
	public void getWindowHandle(WebDriver driver)
	{
		String sessionId=driver.getWindowHandle();
		System.out.println();
		System.out.println("Session(Address) Id of the Window = " +  sessionId);
	}
		
//.....................................................................................................................................................	

	//driver.getWindowhandles()(Child Windows PopUp - 2)
	/**
	*To get a session Id of the multiple Windows(ADDRESS)
	* @param driver
	* @author adminDeepak
	*/
    public void getWindowHandles(WebDriver driver)
	{
		Set<String> sessionId=driver.getWindowHandles();
		System.out.println();
		System.out.println("Session(Address) Id of the multiple Window = " +  sessionId);
	}
				
//.....................................................................................................................................................	
	
  //To count a multiple Windows(Child Windows PopUp - 3)
  	/**
  	*To count a multiple Windows(ADDRESS)
  	* @param driver
  	* @author adminDeepak
  	*/
      public void getWindowHandlesCount(WebDriver driver)
  	{
  		Set<String> sessionId=driver.getWindowHandles();
  		int count=sessionId.size();
  		System.out.println();
  		System.out.println("Number of Windows = " + count);
  	}
  				
//.....................................................................................................................................................	

   //Multiple Window Handles(Child Windows PopUp - 4)
  	/**
  	 * used to Switch to another Window and select WebElement
  	 * @param driver
  	 * @param PartialWindowTitle
  	 * @author adminDeepak
  	 */
  	public void switchToWindow1(WebDriver driver,WebElement Element)
  	{
  		String S1=driver.getWindowHandle();
  		Set<String> S2=driver.getWindowHandles();
  		for(String W:S2)
  		{
  			driver.switchTo().window(W);
  			if(S1.contains(W))
  			{
  				continue;
  			}
  			else
  			{
  				Element.click();
  			}
  		}
  		driver.switchTo().window(S1);
  	}
  	
//.....................................................................................................................................................	
  //Multiple Window Handles(Child Windows PopUp - 5)
  	/**
  	 * used to Switch to any Window based on window title
  	 * @param driver
  	 * @param PartialWindowTitle
  	 * @author adminDeepak
  	 */
  	public void switchToWindow2(WebDriver driver,String PartialWindowTitle)
  	{
  		Set<String> S2=driver.getWindowHandles();
  		Iterator<String> it=S2.iterator();
  		while(it.hasNext())
  		{
  			driver.switchTo().window(it.next());
  			String Title=driver.getTitle();
  			System.out.println();
  			System.out.println(Title);
  			if(Title.contains(PartialWindowTitle))
  			{
  				break;
  			}
  		}
  	}
  	
//.....................................................................................................................................................	

    //Alert PopUp - accept
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 * @author adminDeepak
	 * 
	 */
	public void switchAlertWindowAccpect(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		
		/*if(a.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
         {
			System.out.println("Alert Message is verified");
         }
		else
		{
			System.out.println("Alert Message is not verified");
		}*/
		a.accept();
	}
	
//.....................................................................................................................................................	
	
	//Alert PopUp - Cancel
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 * @author adminDeepak
	 * 
	 */
	public void switchAlertWindowCancel(WebDriver driver, String expectedMsg)
	{
		Alert alt=driver.switchTo().alert();
		
		if(alt.getText().equals(expectedMsg))
         {
			System.out.println("Alert Message is verified");
         }
		else
		{
			System.out.println("Alert Message is not verified");
		}
		alt.dismiss();
	}
      
//.....................................................................................................................................................	
	
	//Handling Frames(Embedded WebPage) by index
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
			public void switchToFrame(WebDriver driver,int index)
			{
				driver.switchTo().frame(index);
			}
		
//.....................................................................................................................................................		
	
	//Handling Frames(Embedded WebPage) by id
	/**
	* used to switch to Frame Window based on id or name attribute
    * @param driver
	* @param id_name_attribute
	*/
	public void switchToframe(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
//.............................................................................................................................................................	.
	
	//Handling Frames(Embedded WebPage)/Switched to default content and parent frame/
	/**
	* used to switch to Frame Window based on id or name attribute
	* @param driver
	* @param id_name_attribute
	*/
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
		
//..............................................................................................................................................................
	
	//Handling of Disabled Elements
	/**
	* used to Enter a Values/Text in Disabled Elements 
	* @param driver
	* @param id_name_attribute
	*/
	public void disabledElement(WebDriver driver)
	{
			RemoteWebDriver r=(RemoteWebDriver)driver;
			r.executeScript("document.getElementById('...........').value='..............'");
	}
	
//..............................................................................................................................................................
	
	//Enter Key By using Robot class
	/**
	 * * pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void EnterKey(WebDriver driver)
	{
	Actions a= new Actions(driver);
	a.sendKeys(Keys.ENTER).perform();
	}
	
//..............................................................................................................................................................

	
		
		
}