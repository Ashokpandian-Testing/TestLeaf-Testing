package TestCases;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.HyperLink_Page;
//@Listeners(HyperLinkPage_Test.class)
public class HyperLinkPage_Test extends TestBase {

	@Test(priority=0, groups= {"Link","Home"})
	public static void Navi_ClickLink() {
		extentreport.createTest("Navi_ClickLink");
		PageFactory.initElements(driver, Pages.HomePage.class);	
		HomePage.Link.click();
		logger.info("Link Button Clicked in Home Page - Successful");
		ExtentLog.log(Status.PASS,"Link Button Clicked in Home Page - Successful");
	}


	@Test(priority=1, dependsOnMethods= {"Navi_ClickLink"}, groups= {"Link"})
	public static void Test11_FindDestination() {
		extentreport.createTest("Test11_FindDestination");
		PageFactory.initElements(driver, HyperLink_Page.class);
		System.out.println(HyperLink_Page.Find.getAttribute("href"));
		logger.info(HyperLink_Page.Find.getAttribute("href"));
		ExtentLog.log(Status.PASS,"Find Destination - Successful");
	}



	@Test(priority=2, dependsOnMethods= {"Navi_ClickLink"}, groups= {"Link"})
	public static void Test12_VerifyBrokenLink() throws MalformedURLException, IOException {
		extentreport.createTest("Test12_VerifyBrokenLink");
		PageFactory.initElements(driver, HyperLink_Page.class);	
		String url = HyperLink_Page.brokenLink.getAttribute("href");
		System.out.println(url);
//		HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
//		huc.setRequestMethod("HEAD");
//		huc.connect();
//		int responsecode = huc.getResponseCode();
//		System.out.println(responsecode);
//		if(responsecode>=400) {
//			logger.error("Link is Broken !");
//			ExtentLog.log(Status.PASS,"VerifyBrokenLink - Successful");
//		}
//		else
//		{
//			logger.info("Link is not Broken");
			ExtentLog.log(Status.FAIL,"VerifyBrokenLink - NOT Successful");
			ExtentLog.fail("Test Case Failed "+ ExtentLog.addScreenCaptureFromPath(getScreenShot(TestBase.driver,HyperLinkPage_Test.class.getName())));
			
//		}
	}



	@Test(priority=3, dependsOnMethods= {"Navi_ClickLink"}, groups= {"Link"})
	public static void Test12_GotoHomePage1() throws InterruptedException {
		extentreport.createTest("Test12_GotoHomePage1");
		PageFactory.initElements(driver, HyperLink_Page.class);	
		HyperLink_Page.GotoHomePage.click();
		Thread.sleep(3000);
		PageFactory.initElements(driver, HomePage.class);
		HomePage.Link.click();
		Thread.sleep(3000);
		
		PageFactory.initElements(driver, HyperLink_Page.class);	
		HyperLink_Page.sameLink.click();
		logger.info("Pressed same link");
		ExtentLog.log(Status.PASS,"GotoHomePage1 - Successful");
		
		
		
	}
	
	
	@Test(priority=4, dependsOnMethods= {"Navi_ClickLink"} , groups= {"Link"})
	public static void Test14_CountLink() throws InterruptedException {
		extentreport.createTest("Test14_CountLink");
		PageFactory.initElements(driver, HyperLink_Page.class);	
		System.out.println(HyperLink_Page.LinkCount.size());
		logger.info("Link Count is : "+HyperLink_Page.LinkCount.size());
		ExtentLog.log(Status.PASS,"Total Link Count in Link Page : " +HyperLink_Page.LinkCount.size());
	}

}
