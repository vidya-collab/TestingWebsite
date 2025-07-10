package stepdefinitions;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.LoginOrange_pf;
import utils.LoggerLoad;


public class LoginOrange_sd {
	LoginOrange_pf loginOrange_pf =new  LoginOrange_pf(); 
	
	
	@Given("The users is on the OrangeHRMLogin in Page")
	public void the_users_is_on_the_orange_hrm_login_in_page() {
		LoggerLoad.info("The users is on the OrangeHRMLogin in Page");
	   
	}


	@When("The users enters login button after entering valid {string} and {int}")
	public void the_users_enters_login_button_after_entering_valid_and(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
    
		String Username =loginOrange_pf.getusernamefromExcel(Sheetname, Rownumber);
		String Password =loginOrange_pf.getpasswordfromExcel(Sheetname, Rownumber);
		loginOrange_pf.loginOrange(Username,Password );
		

		
	}

	@Then("The user should be redirected to dashboard page of orange HRM")
	public void the_user_should_be_redirected_to_dashboard_page_of_orange_hrm() {
		
		
		String actualTitle = loginOrange_pf.validateDashBoardpage();
		String expectedTitle= "Dashboard";
	    Assert.assertEquals(actualTitle, expectedTitle,"Title does not match");
		LoggerLoad.info("The user should be redirected to dashboard page of orange HRM");
	 
		 
	    
	}
	
	@When("The users clicks login button after entering invalid username {string} and {int}")
	public void the_users_enters_login_button_after_entering_invalid_username_and(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
    
		String Username =loginOrange_pf.getusernamefromExcel(Sheetname, Rownumber);
		String Password =loginOrange_pf.getpasswordfromExcel(Sheetname, Rownumber);
		loginOrange_pf.invalidLoginOrange1(Username,Password );
			
	}
	
	@When("The users clicks login button after entering invalid password {string} and {int}")
	public void the_users_enters_login_button_after_entering_invalid_password_and(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
    
		String Username =loginOrange_pf.getusernamefromExcel(Sheetname, Rownumber);
		String Password =loginOrange_pf.getpasswordfromExcel(Sheetname, Rownumber);
		loginOrange_pf.invalidLoginOrange2(Username,Password );
			
	}
	
	
	@When("The users clicks login button after entering empty username {string} and {int}")
	public void the_users_clicks_login_button_after_entering_empty_username_and(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		String Username =loginOrange_pf.getusernamefromExcel(Sheetname, Rownumber);
		String Password =loginOrange_pf.getpasswordfromExcel(Sheetname, Rownumber);
		loginOrange_pf.invalidLoginOrange3(Username,Password );
	}

	@When("The users clicks login button after entering empty passowrd {string} and {int}")
	public void the_users_clicks_login_button_after_entering_empty_passowrd_and(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		String Username =loginOrange_pf.getusernamefromExcel(Sheetname, Rownumber);
		String Password =loginOrange_pf.getpasswordfromExcel(Sheetname, Rownumber);
		loginOrange_pf.invalidLoginOrange4(Username,Password );
	}

	
	@Then("The user should get meesage invalid {string}")
	public void the_user_should_get_meesage_invalid(String string) {
		
		Assert.assertTrue(loginOrange_pf.isInvalidCredentialDisplayed(), "Invalid credentials message not displayed");

	}
	
	@Then("The user should get meesage Required for username")
	public void the_user_should_get_meesage_required_for_username() {
		Assert.assertTrue(loginOrange_pf.isRequiredforusernameDisplayed(), "Reqired username not displayed");
	}

	@Then("The user should get meesage Required for password")
	public void the_user_should_get_meesage_required_for_password() {
		Assert.assertTrue(loginOrange_pf.isRequiredforpasswordDisplayed(), "Reqired password not displayed");
	}


	

}
