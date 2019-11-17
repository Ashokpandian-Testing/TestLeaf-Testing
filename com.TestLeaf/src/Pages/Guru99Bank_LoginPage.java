package Pages;


import org.openqa.selenium.support.FindBy;

import TestCases.TestBase;

import org.openqa.selenium.WebElement;
import TestCases.TestBase;

public class Guru99Bank_LoginPage {
	
	
	@FindBy(name="uid")
	public static WebElement username;
	
	
	@FindBy(name="password")
	public static WebElement password;
	
	@FindBy(name="btnLogin")
	public static WebElement loginbutton;
	
	@FindBy(xpath="//a[@href=\"Managerhomepage.php\"]")
	public static WebElement managerhomepage;
	
	
	

}
