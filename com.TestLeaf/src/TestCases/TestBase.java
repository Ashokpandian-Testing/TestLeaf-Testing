package TestCases;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	
	
	@BeforeSuite(alwaysRun=true)
	public static WebDriver InitDriver() throws IOException {	
		
		if(LoadConfigFile("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", LoadConfigFile("ChromeDriverPath"));
			driver = new ChromeDriver();		
			
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://www.leafground.com/home.html");
		return driver;
		
	}
	
	public static String LoadConfigFile(String key) throws IOException {
		
//		InputStream inputfile = TestBase.class.getResourceAsStream("/Pages/config.properties");	
		FileInputStream inputfile = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(inputfile);
		String temp = prop.getProperty(key);
		inputfile.close();
		
//		FileOutputStream out = new FileOutputStream("config.properties");
//		prop.setProperty("ChromeDriverPath", "D:\\MMA_Automation\\chromedriver.exe");		
//		prop.store(out, null);
//		out.close();
		return temp;
	}
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"Application"})
	public static void LaunchAppURL(@Optional("TestLeaf") String Key) {
		
		if(Key.equalsIgnoreCase("TestLeaf")) {
		driver.get("http://www.leafground.com/home.html");
		}
		else if(Key.equalsIgnoreCase("guru99bank")) {
			driver.get("http://demo.guru99.com/V1/index.php");
		}
		
		driver.manage().window().maximize();
	}
	
	
	
	
	@AfterSuite(alwaysRun=true)
	public static void  quitDriver() {
		driver.quit();
	}

}
