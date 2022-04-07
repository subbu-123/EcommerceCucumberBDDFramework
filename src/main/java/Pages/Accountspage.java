package Pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GenericUtilities;

public class Accountspage {


	WebDriver driver;
	GenericUtilities gutil= new GenericUtilities();;
	WebDriverWait wait;
	
	public Accountspage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}
	
	private By accountPageSection = By.xpath("//*[contains(@class,'row addresses-lists')]//span");
	private By contactUs = By.xpath("//*[text()='Contact us']");
	
	public String getAccountpageTitle()
	{
		return gutil.getPageTitle(driver);
	}
	
	public List<String> getAccountPageSections()
	{
		List<WebElement> sectionElements = driver.findElements(accountPageSection);
		List<String> sectionNames = sectionElements.stream().map(e -> e.getText()).collect(Collectors.toList());
		return sectionNames;
	}
	
	public ContactUsPage clickOnContactUsLink()
	{
		WebElement ContactUsLink = driver.findElement(contactUs);
		wait.until(ExpectedConditions.visibilityOf(ContactUsLink));
		gutil.ClickOnButton(ContactUsLink);
		return new ContactUsPage(driver);
	}
	
}
