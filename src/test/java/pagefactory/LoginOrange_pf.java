package pagefactory;


import java.io.IOException;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.netty.handler.timeout.TimeoutException;
import utils.ExcelReader;
import utils.ConfigReader;
import utils.DriverManager;
import java.time.Duration;


public class LoginOrange_pf {
	
	
	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();
	ExcelReader reader = new ExcelReader();      // add for data driven 
	String Excelpath = ConfigReader.excelpath(); // add for data driven 

	//-----------------@FIndBy method for locartors(xpath)-------------------------
	
	@FindBy(xpath = "//input[@name='username']") WebElement username;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//span[text()='Dashboard']")WebElement DashBoard;
	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text') and text()='Invalid credentials']")WebElement Errormsg;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")WebElement LoginButton;

	//-------------------------------------constructor for initializing driver---------
	
	public LoginOrange_pf() {    
		
		PageFactory.initElements(driver , this);

	}
	
	//-------------- code for getting value of username and password from excel sheet------
	
	public String getusernamefromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	

		List<Map<String,String>> testData = 
				reader.getData(Excelpath, Sheetname);

		String Uname  = testData.get(Rownumber).get("Username");
		return Uname;
	}

	public String getpasswordfromExcel(String Sheetname, int Rownumber)  throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException  {	

		List<Map<String,String>> testData = 
				reader.getData(Excelpath, Sheetname);

		String Pd  = testData.get(Rownumber).get("Password");
		return Pd;
	}
	
	//--------------- sending value to text box of user name and password and click login button-----------
	
	public void  loginOrange(String Uname, String Pd ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
		List<Map<String,String>> testData = 
				reader.getData(Excelpath, "Loginsheet");
		Uname = testData.get(0).get("Username");
		Pd = testData.get(0).get("Password");
		//username.clear();
		username.sendKeys(Uname);
		//password.clear();
		password.sendKeys(Pd);
		LoginButton.click();	
		}
	
	//----------------Validate Dashborad page is comimg-------------------------------------------
	
	public String validateDashBoardpage() {
		String dashBoard=DashBoard.getText();
		return dashBoard;

	}
	
	//-----------------for sending invalid credentials invalid username --------------
	
	public void invalidLoginOrange1(String Uname, String Pd ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
		List<Map<String,String>> testData = 
				reader.getData(Excelpath, "Loginsheet");
		Uname = testData.get(1).get("Username");
		Pd = testData.get(1).get("Password");
		//username.clear();
		username.sendKeys(Uname);
		//password.clear();
		password.sendKeys(Pd);
		LoginButton.click();
			
		}
	
	//-----------------for sending invalid credentials invalid password --------------
	
		public void invalidLoginOrange2(String Uname, String Pd ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
			List<Map<String,String>> testData = 
					reader.getData(Excelpath, "Loginsheet");
			Uname = testData.get(2).get("Username");
			Pd = testData.get(2).get("Password");
			//username.clear();
			username.sendKeys(Uname);
			//password.clear();
			password.sendKeys(Pd);
			LoginButton.click();
				
			}
	
	
		//-----------------for sending invalid credentials empty username --------------
		
		public void invalidLoginOrange3(String Uname, String Pd ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
			List<Map<String,String>> testData = 
					reader.getData(Excelpath, "Loginsheet");
			Uname = testData.get(3).get("Username");
			Pd = testData.get(3).get("Password");
			//username.clear();
			username.sendKeys(Uname);
			//password.clear();
			password.sendKeys(Pd);
			LoginButton.click();
				
			}
	
		//-----------------for sending invalid credentials empty password --------------
		
		public void invalidLoginOrange4(String Uname, String Pd ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
			List<Map<String,String>> testData = 
					reader.getData(Excelpath, "Loginsheet");
			Uname = testData.get(4).get("Username");
			Pd = testData.get(4).get("Password");
			//username.clear();
			username.sendKeys(Uname);
			//password.clear();
			password.sendKeys(Pd);
			LoginButton.click();
				
			}
	//-------------for catching error message invalid credentials ---------//
	
	
	public boolean isInvalidCredentialDisplayed() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//p[contains(@class,'oxd-alert-content-text') and text()='Invalid credentials']")
	        ));
	        return errorElement.isDisplayed();
	    } catch (TimeoutException e) {
	        return false; // Element not found within timeout
	    }
	}
	

	//---------- for catching reqiured msg for username--------------------------------------------------------------------



	public boolean isRequiredforusernameDisplayed() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        WebElement req1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[text()='Required']")
	        ));
	        return req1Element.isDisplayed();
	    } catch (TimeoutException e) {
	        return false; // Element not found within timeout
	    }
	}
	//---------- for catching reqiured msg for password--------------------------------------------------------------------



		public boolean isRequiredforpasswordDisplayed() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    try {
		        WebElement req1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//span[text()='Required']")
		        ));
		        return req1Element.isDisplayed();
		    } catch (TimeoutException e) {
		        return false; // Element not found within timeout
		    }
		}
}
