package TestCases;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	
	
	@BeforeSuite
	public static WebDriver InitDriver() throws IOException {	
		
		if(LoadConfigFile("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\MMA_Automation\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/home.html");
		return driver;
		
	}
	
	public static String LoadConfigFile(String Key) throws IOException {
//		FileInputStream inputfile = new FileInputStream("config.properties");
		
		InputStream inputfile = TestBase.class.getClassLoader().getResourceAsStream("/com.TestLeaf/src/Configurations/config.properties");
		
		Properties prop = new Properties();
		prop.load(inputfile);
		
		return prop.getProperty(Key);
		
		
		
	}
	
	@BeforeMethod
	public static void LaunchAppURL() {
		driver.get("http://www.leafground.com/home.html");
	}
	
	
	@AfterSuite
	public static void  quitDriver() {
		driver.quit();
	}

}
