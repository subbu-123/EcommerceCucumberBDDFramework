package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtilities {
	
	public void launchURL(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public void enterTextinInputField(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	public void clearTextPresentinInputField(WebElement element)
	{
		element.clear();
	}
	
	public void ClickOnButton(WebElement element)
	{
		element.click();
	}
	
	public void SelectValueFromDropDown(WebElement element, String val)
	{
		Select s = new Select(element);
		s.selectByVisibleText(val);
	}
	
	
	
}
