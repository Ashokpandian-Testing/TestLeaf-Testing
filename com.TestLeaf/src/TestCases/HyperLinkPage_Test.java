package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HyperLink_Page;
//@Listeners(HyperLinkPage_Test.class)
public class HyperLinkPage_Test extends TestBase {

	@Test(priority=0, groups= {"Link","Home"})
	public static void Navi_ClickLink() {
		PageFactory.initElements(driver, Pages.HomePage.class);	
		HomePage.Link.click();
		logger.info("Link Button Clicked in Home Page - Successful");
	}


	@Test(priority=1, dependsOnMethods= {"Navi_ClickLink"}, groups= {"Link"})
	public static void Test11_FindDestination() {
		PageFactory.initElements(driver, HyperLink_Page.class);
		System.out.println(HyperLink_Page.Find.getAttribute("href"));
		logger.info(HyperLink_Page.Find.getAttribute("href"));
	}



	@Test(priority=2, dependsOnMethods= {"Navi_ClickLink"}, groups= {"Link"})
	public static void Test12_VerifyBrokenLink() throws MalformedURLException, IOException {
		PageFactory.initElements(driver, HyperLink_Page.class);	
		String url = HyperLink_Page.brokenLink.getAttribute("href");
		System.out.println(url);
		HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
		huc.setRequestMethod("HEAD");
		huc.connect();
		int responsecode = huc.getResponseCode();
		System.out.println(responsecode);
		if(responsecode>=400) {
			logger.error("Link is Broken !");
		}
		else
		{
			logger.info("Link is not Broken");
		}
	}



	@Test(priority=3, dependsOnMethods= {"Navi_ClickLink"}, groups= {"Link"})
	public static void Test12_GotoHomePage1() throws InterruptedException {
		PageFactory.initElements(driver, HyperLink_Page.class);	
		HyperLink_Page.GotoHomePage.click();
		Thread.sleep(3000);
		PageFactory.initElements(driver, HomePage.class);
		HomePage.Link.click();
		Thread.sleep(3000);
		
		PageFactory.initElements(driver, HyperLink_Page.class);	
		HyperLink_Page.sameLink.click();
		logger.info("Pressed same link");
	}
	
	
	@Test(priority=3, dependsOnMethods= {"Navi_ClickLink"} , groups= {"Link"})
	public static void Test14_CountLink() throws InterruptedException {
		PageFactory.initElements(driver, HyperLink_Page.class);	
		System.out.println(HyperLink_Page.LinkCount.size());
		logger.info("Link Count is : "+HyperLink_Page.LinkCount.size());
		
	}

}
