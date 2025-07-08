package stepdefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.LoginOrange_pf;
import utils.LoggerLoad;


public class LoginOrange_sd {
	LoginOrange_pf login =new  LoginOrange_pf(); 
	
	
	@Given("The users is on the OrangeHRMLogin in Page")
	public void the_users_is_on_the_orange_hrm_login_in_page() {
		LoggerLoad.info("The users is on the OrangeHRMLogin in Page");
	   
	}


	@When("The users enters login button after entering valid {string} and {int}")
	public void the_users_enters_login_button_after_entering_valid_and(String Sheetname, Integer Rownumber) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
    
		String Username =login.getusernamefromExcel(Sheetname, Rownumber);
		String Password =login.getpasswordfromExcel(Sheetname, Rownumber);
		login.login2(Username,Password );

		
	}

	@Then("The user should be redirected to dashboard page of orange HRM")
	public void the_user_should_be_redirected_to_dashboard_page_of_orange_hrm() {
		LoggerLoad.info("The user should be redirected to dashboard page of orange HRM");
	    
	}
	
	
	
	

}
