package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties getConfigProperties()
	{
		prop = new Properties();
		try {
			String filepath = System.getProperty("user.dir") + "/src/test/resources/Configurations/config.properties";
			FileInputStream fis = new FileInputStream(filepath);
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return prop;
	}
	
	
	

}
