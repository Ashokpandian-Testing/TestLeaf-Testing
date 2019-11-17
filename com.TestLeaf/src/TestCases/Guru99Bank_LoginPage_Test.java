package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import Pages.Guru99Bank_LoginPage;
import javafx.scene.control.Alert;

public class Guru99Bank_LoginPage_Test extends TestBase {
	
	@Test(priority=0,dataProvider="logindata")
	@Parameters({"username","password"})
	public static void Login_Guru99Bank_ValidCheck(@Optional("mngr233361") String username, @Optional("tAguqEg") String password) {	
		PageFactory.initElements(driver, Guru99Bank_LoginPage.class);
		Guru99Bank_LoginPage.username.sendKeys(username);
		Guru99Bank_LoginPage.password.sendKeys(password);
		Guru99Bank_LoginPage.loginbutton.click();
		Boolean temp = Guru99Bank_LoginPage.managerhomepage.isDisplayed();
		
		if(temp.equals(true)) {
			System.out.println("Login Successful with username : "+username);
		}
		else {
			System.out.println("Login was not Successful with username : "+username);
			driver.switchTo().alert().accept();			
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
