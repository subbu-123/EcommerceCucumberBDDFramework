package StepDefinitions;

import java.util.List;

import com.codoid.products.exception.FilloException;

import Pages.Accountspage;
import Pages.ContactUsPage;
import Pages.LoginPage;
import Utilities.DriverFactory;
import Utilities.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactUsPageStepDef {

	Accountspage ap = new Accountspage(DriverFactory.getDriver());
	ContactUsPage cup;
	ExcelUtility exutil;
	
	 @Given("^user is on Contact Us page$")
	    public void user_is_on_contact_us_page() {
	        
		 cup = ap.clickOnContactUsLink();
	    }

	    @When("^user fills the form with details from (.+) and from (.+)$")
	    public void user_fills_the_form_with_details_from_and_from(String sheetname, int rownumber) {
	    	
	    	exutil = new ExcelUtility();
	    	String subject;
	    	String email;
	    	String message;
	    	try {
				List<Object[]> testData = exutil.getDataFromExcel("./DataSheet.xlsx", sheetname);
				subject = (String) testData.get(rownumber)[0];
				email = (String) testData.get(rownumber)[1];
				message = (String) testData.get(rownumber)[2];
				
				//System.out.println(subject+" "+email+" "+message);
				
				cup.fillForm(subject, email, message); 
			} catch (FilloException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	        
	    }

	    @Then("^a messsage should be displayed as \"([^\"]*)\"$")
	    public void a_messsage_should_be_displayed_as_something(String expectedMessage) {
	    	
	    	String ActualMessage = cup.getMessageUponSending();
	        Assert.assertEquals(expectedMessage, ActualMessage);
	    }

	    @And("^clicks on send button$")
	    public void clicks_on_send_button() {
	        
	    	cup.clickSendButton();
	    }

}
