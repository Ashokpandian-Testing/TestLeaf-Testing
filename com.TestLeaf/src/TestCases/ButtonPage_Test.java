package TestCases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sun.media.jfxmedia.logging.Logger;

import Pages.ButtonPage;
import Pages.HomePage;

public class ButtonPage_Test extends TestBase {
	
	@Test(priority=0, groups= {"Button","Home"})
	public static void Navi_ClickButton() {
		PageFactory.initElements(TestBase.driver, HomePage.class);
		HomePage.Button.click();
		logger.info("Button Button Clicked in Home Page - Successful");
	}
	
	@Test(priority=4, groups= {"Button"})
	public static void Test07_CheckGotoHomeButton() {		
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		ButtonPage.GotoHome.click();
//		System.out.println("Goto Home Button Was Pressed");
		logger.info("Goto Home Button Was Pressed");
	}
	
	
	@Test(priority=2, groups= {"Button"})
	public static void Test08_GetPosition() {		
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		Point point = ButtonPage.Position.getLocation();
//		System.out.println("Button X Axis : "+point.getX()+" & Button Y Axis : "+point.getY());
		logger.info("Button X Axis : "+point.getX()+" & Button Y Axis : "+point.getY());
	}
	
	
	@Test(priority=3, groups= {"Button"})
	public static void Test09_GetColor() {		
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		String color = ButtonPage.Color.getCssValue("background-color");	
//		System.out.println("Button Color : "+color);
		logger.info("Button Color : "+color);
	}
	
	
	@Test(priority=1, groups= {"Button"})
	public static void Test10_GetSize() {		
		PageFactory.initElements(TestBase.driver, ButtonPage.class);
		Dimension dim = ButtonPage.Size.getSize();		
//		System.out.println("Button Height : "+dim.getHeight()+" & Button Weight : "+dim.getWidth());
		logger.info("Button Height : "+dim.getHeight()+" & Button Weight : "+dim.getWidth());
	}
	

}
