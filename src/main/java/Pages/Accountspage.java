package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GenericUtilities;

public class Accountspage {


	WebDriver driver;
	GenericUtilities gutil;
	WebDriverWait wait;
	
	public Accountspage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By accountPageSection = By.xpath("//*[contains(@class,'row addresses-lists')]//span");
	
	public String getAccountpageTitle()
	{
		gutil = new GenericUtilities();
		return gutil.getPageTitle(driver);
	}
	
	public List<String> getAccountPageSections()
	{
		List<WebElement> sectionElements = driver.findElements(accountPageSection);
		List<String> sectionNames = sectionElements.stream().map(e -> e.getText()).collect(Collectors.toList());
		return sectionNames;
	}
	
}
