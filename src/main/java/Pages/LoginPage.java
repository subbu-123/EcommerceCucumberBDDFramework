package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GenericUtilities;

public class LoginPage {
	
	WebDriver driver;
	GenericUtilities gutil = new GenericUtilities();
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signIN = By.id("SubmitLogin");
	private By forgotLink = By.xpath("//*[contains(text(),'Forgot your password?')]");
	
	public String getLoginpageTitle()
	{
		return gutil.getPageTitle(driver);
	}
	
	public boolean forgotLinkDisplayed()
	{
		WebElement el= driver.findElement(forgotLink);
		wait.until(ExpectedConditions.visibilityOf(el));
		return gutil.isElementDisplayed(el);
	}
	
	
	public void enterUsername(String username)
	{
		WebElement el= driver.findElement(emailID);
		wait.until(ExpectedConditions.visibilityOf(el));
		gutil.enterTextinInputField(el,username);
	}
	
	public void enterPassword(String passwrd)
	{
		WebElement el= driver.findElement(password);
		wait.until(ExpectedConditions.visibilityOf(el));
		gutil.enterTextinInputField(el,passwrd);
	}
	
	public Accountspage clickingOnSigInButton()
	{
		WebElement el= driver.findElement(signIN);
		wait.until(ExpectedConditions.visibilityOf(el));
		gutil.ClickOnButton(el);
		return new Accountspage(driver);
	}
	
	public Accountspage doLogin(String un, String pwd)
	{
		WebElement email= driver.findElement(emailID);
		WebElement passwrd= driver.findElement(password);
		WebElement loginBtn= driver.findElement(signIN);
		
		gutil.enterTextinInputField(email,un);
		gutil.enterTextinInputField(passwrd,pwd);
		gutil.ClickOnButton(loginBtn);
		
		return new Accountspage(driver);
	}
	
}
