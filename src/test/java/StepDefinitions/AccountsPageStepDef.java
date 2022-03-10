package StepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import Pages.Accountspage;
import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.DriverFactory;
import Utilities.GenericUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AccountsPageStepDef {

	LoginPage lp =new LoginPage(DriverFactory.getDriver());
	Accountspage ap;
	
	GenericUtilities gutil = new GenericUtilities();
	ConfigReader cr = new ConfigReader();
	Properties prop = cr.getConfigProperties();
	
	String actualAccountpageTitle;
	List<String> actualAccountPageSections;
	
	@Given("^user has already logged into application with valid credentials$")
    public void user_has_already_logged_into_application_with_valid_credentials(DataTable credentials) {
        
		List<Map<String, String>> credmap = credentials.asMaps();
		
		gutil.launchURL(DriverFactory.getDriver(), prop.getProperty("url"));
		ap = lp.doLogin(credmap.get(0).get("username"), credmap.get(0).get("password"));
    }

    @Given("^user is on Accounts page$")
    public void user_is_on_accounts_page() {
        
    	actualAccountpageTitle = ap.getAccountpageTitle();
    }

    @When("^accounts page sections are retrieved$")
    public void accounts_page_sections_are_retrieved() {
        
    	actualAccountPageSections = ap.getAccountPageSections();
    }

    @Then("^Accounts page title should be displayed as \"([^\"]*)\"$")
    public void accounts_page_title_should_be_displayed_as_something(String expectedAccountpageTitle) {
    	
    	Assert.assertEquals(expectedAccountpageTitle, actualAccountpageTitle);
        
    }

    @Then("^below accounts section are displayed$")
    public void below_accounts_section_are_displayed(DataTable Sections) {
        
    	List<String> expectedAccountPageSections = Sections.asList();
    	Assert.assertEquals(expectedAccountPageSections, actualAccountPageSections);
    }

    @And("accounts section total count should be {int}")
    public void accounts_section_total_count(int expectedSectionCount) {
        
    	int actualCount = actualAccountPageSections.size();
    	Assert.assertEquals(expectedSectionCount, actualCount);
    }

	
	
}
