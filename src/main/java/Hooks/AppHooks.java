package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private WebDriver driver;
	private Properties prop;
	private ConfigReader configReader;
	private DriverFactory df;
	
	//Here the sequence in which the hook methods are written they will be executed in the same way. on the basis of that remember the "order" attribute behaviour
	
	@Before(order=0)
	public void readConfigFile()
	{
		configReader = new ConfigReader();
		prop = configReader.getConfigProperties();
		
	}
	
	@Before(order=1)
	public void driverInitialization()
	{
		df = new DriverFactory();
		driver = df.initialize_driver(prop.getProperty("browser"));
		
	}
	
	@After(order=1)
	public void failureScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotName = scenario.getName().replace(" ", "_");
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenshotName);
		}
	}
	
	@After(order=0)
	public void teardown()
	{
		driver.quit();
	}
	
}
