package StepDefinitions;

import java.util.Properties;

import Pages.Accountspage;
import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.DriverFactory;
import Utilities.GenericUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginPageStepDef {

	LoginPage lp =new LoginPage(DriverFactory.getDriver());
	Accountspage ap;
	
	GenericUtilities gutil = new GenericUtilities();
	ConfigReader cr = new ConfigReader();
	Properties prop = cr.getConfigProperties();
	String actualAccountpageTitle;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {

		gutil.launchURL(DriverFactory.getDriver(), prop.getProperty("url"));
	}

	@When("^user enters username as \"([^\"]*)\"$")
	public void user_enters_username(String username) {

		lp.enterUsername(username);
	}

	@And("^enters password as  \"([^\"]*)\"$")
	public void enters_password(String password) {

		lp.enterPassword(password);
	}

	@Then("^login page title should be displayed as \"([^\"]*)\"$")
	public void login_page_title_should_be_displayed(String loginPageTitle) {

		String actualTitle = lp.getLoginpageTitle();
		Assert.assertEquals(loginPageTitle, actualTitle);
	}

	@Then("^\"([^\"]*)\" should be displayed$")
	public void something_should_be_displayed(String forgotLink) {

		Assert.assertTrue(lp.forgotLinkDisplayed());
	}

	@Then("^user should be navigated to Accounts page$")
	public void user_should_be_navigated_to_accounts_page() {

		actualAccountpageTitle = ap.getAccountpageTitle();
	}

	@And("^clicks on Login button$")
	public void clicks_on_login_button() {

		ap = lp.clickingOnSigInButton();
	}

	@And("^accounts page title should be displayed as \"([^\"]*)\"$")
	public void accounts_page_title_should_be_displayed(String accountPageTitle) {
		
		Assert.assertEquals(accountPageTitle, actualAccountpageTitle);

	}

}
