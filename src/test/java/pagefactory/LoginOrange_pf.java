package pagefactory;


import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import utils.ExcelReader;
import utils.ConfigReader;
import utils.DriverManager;

public class LoginOrange_pf {
	
	
	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();

	
	
	//input[@name='username']
	//input[@name='password']
	
	//input[@placeholder='Username']
	//input[@placeholder='Password']
	//button[@type='submit']
	
	@FindBy(xpath = "//input[@name='username']") WebElement username;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//button[contains(@class,'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]") WebElement login;
	
	ExcelReader reader = new ExcelReader();      // add for data driven 
	String Excelpath = ConfigReader.excelpath(); // add for data driven 
	
	public LoginOrange_pf() {
		
		PageFactory.initElements(driver , this);

	}
	
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
	
	
	public void  login2(String Uname, String Pd ) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
		List<Map<String,String>> testData = 
				reader.getData(Excelpath, "Loginsheet");
		Uname = testData.get(0).get("Username");
		Pd = testData.get(0).get("Password");
		//username.clear();
		username.sendKeys(Uname);
		//password.clear();
		password.sendKeys(Pd);
		login.click();	
		}
	
	
	

}
