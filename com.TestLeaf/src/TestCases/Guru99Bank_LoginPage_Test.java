package TestCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import Pages.Guru99Bank_LoginPage;

public class Guru99Bank_LoginPage_Test extends TestBase {
	
	@Test(priority=0,dataProvider="logindata")
	@Parameters({"username","password"})
	public static void Login_Guru99Bank_ValidCheck(@Optional("mngr233361") String username, @Optional("tAguqEg") String password) throws InterruptedException {	
		PageFactory.initElements(driver, Guru99Bank_LoginPage.class);
		Guru99Bank_LoginPage.username.sendKeys(username);
		Guru99Bank_LoginPage.password.sendKeys(password);
		Guru99Bank_LoginPage.loginbutton.click();
		
		
		if(isAlertPresent().equals(true)) {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}
		else if(driver.getCurrentUrl().equalsIgnoreCase(Guru99Bank_LoginPage.LandingPageURL)) {
			System.out.println("Login Successful with username : "+username);
		}
		
		
	}
	
	@DataProvider(name="logindata")
	public Object[][] logindata(){
		
		return new Object[][] {		
			{"mngr233362","tAguqE8"},
			{"mngr233361","tAguqEu"},
			{"mngr233361","tAguqEg"}};
	}
}
