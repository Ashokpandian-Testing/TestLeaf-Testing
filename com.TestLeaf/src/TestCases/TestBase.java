package TestCases;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase implements ITestListener,IRetryAnalyzer, IAnnotationTransformer {
	
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(TestBase.class);
	public static ExtentReports extentreport;
	public static ExtentHtmlReporter htmlreporter;	
	public static ExtentTest ExtentLog;
	
	
	int RetryCount = 0;
	int MaxRetry = 4;
	
	
	@BeforeSuite(alwaysRun=true)
	public static WebDriver InitDriver() throws IOException {	

		extentreport = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter("ExtentReport.html");
		extentreport.attachReporter(htmlreporter);
		
		if(LoadConfigFile("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", LoadConfigFile("ChromeDriverPath"));
			driver = new ChromeDriver();								
		}
		PropertyConfigurator.configure("Log4j.properties");
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
	
	@BeforeClass(alwaysRun=true)
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
	
	
	public static Boolean isAlertPresent() {
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException ex) {
			return false;
		}
	}
	
	@AfterSuite(alwaysRun=true)
	public static void  quitDriver() {
		driver.quit();
	}
	
//	@Override
//public void onStart(ITestResult args) {
//	// TODO Auto-generated method stub
//logger.info("Execution started for : '" +args.getMethod().getMethodName()+"'");
//}
//@Override
//public void onFinish(ITestContext args) {
//	// TODO Auto-generated method stub
//	logger.info("Execution started for : '" +args.setAttribute("", value););
//}


@Override
public void onTestFailure(ITestResult args) {
	// TODO Auto-generated method stub
	logger.info("Test Case - '" +args.getMethod().getMethodName()+"' Failed");
}

@Override
public void onTestSuccess(ITestResult args) {
	// TODO Auto-generated method stub
	logger.info("Test Case - '" +args.getMethod().getMethodName()+"' Passed");
}

@Override
public void onTestSkipped(ITestResult args) {
	// TODO Auto-generated method stub
	logger.info("Test Case - '" +args.getMethod().getMethodName()+"' Skipped");
}


@Override
public void onTestStart(ITestResult args) {
	// TODO Auto-generated method stub
	logger.info("Test Case - '" +args.getMethod().getMethodName()+"' Started");
	
}

@Override
public boolean retry(ITestResult result) {
	// TODO Auto-generated method stub
	
	if(RetryCount < MaxRetry) {
		RetryCount++;
		System.out.println("RetryCount");
		return true;
		
	}
	return false;
}


@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	// TODO Auto-generated method stub
	annotation.setRetryAnalyzer(TestBase.class);
}


}
