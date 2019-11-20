package TestCases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sun.media.jfxmedia.logging.Logger;

import Pages.ButtonPage;
import Pages.HomePage;

public class ButtonPage_Test extends TestBase {
	
	@Test(priority=0, groups= {"Button","Home"})
	public static void Navi_ClickButton() {
		ExtentLog = extentreport.createTest("Verify - Click \"Button\" in Home Page");
		PageFactory.initElements(TestBase.driver, HomePage.class);
		HomePage.Button.click();
		logger.info("Button Button Clicked in Home Page - Successful");
		ExtentLog.log(Status.INFO, "'Button' Clicked in Home Page - Successfully");
	}
	
	@Test(priority=4, groups= {"Button"})
	public static void Test07_CheckGotoHomeButton() {		
		ExtentLog = extentreport.createTest("Verify - 'Goto Home' Button in 'Button Page'");
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		ButtonPage.GotoHome.click();
//		System.out.println("Goto Home Button Was Pressed");
		logger.info("Goto Home Button Was Pressed");
		ExtentLog.log(Status.PASS, "'Goto Home' Button Was Pressed");
	}
	
	
	@Test(priority=2, groups= {"Button"})
	public static void Test08_GetPosition() {	
		ExtentLog = extentreport.createTest("Verify - 'Button Position' in 'Button Page'");
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		Point point = ButtonPage.Position.getLocation();
//		System.out.println("Button X Axis : "+point.getX()+" & Button Y Axis : "+point.getY());
		logger.info("Button X Axis : "+point.getX()+" & Button Y Axis : "+point.getY());
		ExtentLog.log(Status.PASS, "'Get Position' is successful");
	}
	
	
	@Test(priority=3, groups= {"Button"})
	public static void Test09_GetColor() {		
		ExtentLog = extentreport.createTest("Verify - 'Get color' in 'Button Page'");
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		String color = ButtonPage.Color.getCssValue("background-color");	
//		System.out.println("Button Color : "+color);
		logger.info("Button Color : "+color);
		ExtentLog.log(Status.PASS, "'Get Color' is successful");
	}
	
	
	@Test(priority=1, groups= {"Button"})
	public static void Test10_GetSize() {	
		ExtentLog = extentreport.createTest("Verify - 'Get color' in 'Button Page'");
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		Dimension dim = ButtonPage.Size.getSize();		
//		System.out.println("Button Height : "+dim.getHeight()+" & Button Weight : "+dim.getWidth());
		logger.info("Button Height : "+dim.getHeight()+" & Button Weight : "+dim.getWidth());
		ExtentLog.log(Status.PASS, "'Get Size' is successful");
	}
	

}
