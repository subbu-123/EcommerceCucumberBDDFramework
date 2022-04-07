package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GenericUtilities;

public class ContactUsPage {
	
	WebDriver driver;
	GenericUtilities gutil= new GenericUtilities();;
	WebDriverWait wait;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	private By subjectHeading = By.xpath("//*[@id='id_contact']");
	private By emailAddress = By.xpath("//*[@id='email']");
	private By userMessage = By.xpath("//*[@id='message']");
	private By sendBtn = By.xpath("//*[@id='submitMessage']");
	private By successMessage = By.xpath("//*[contains(@class,'success')]");
	
	public void fillForm(String subject, String email, String message)
	{
		WebElement subjectDropdown = driver.findElement(subjectHeading);
		WebElement Email = driver.findElement(emailAddress);
		WebElement Message = driver.findElement(userMessage);
		
		//wait.until(ExpectedConditions.visibilityOf(subjectDropdown));    need to check y this step is failing
		gutil.SelectValueFromDropDown(subjectDropdown, subject);
		gutil.clearTextPresentinInputField(Email);
		gutil.enterTextinInputField(Email, email);
		gutil.enterTextinInputField(Message, message);
		
	}
	
	public void clickSendButton()
	{
		WebElement sendButton = driver.findElement(sendBtn);
		gutil.ClickOnButton(sendButton);
	}
	
	
	public String getMessageUponSending()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		return driver.findElement(successMessage).getText();
	}
	
	
}
