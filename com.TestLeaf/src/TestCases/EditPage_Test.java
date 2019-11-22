package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.EditPage;
import Pages.HomePage;

public class EditPage_Test extends TestBase {
	
//  @Test
//  public void ClickEdit() {	  
//	  HomePage.TextEdit(TestBase.driver).click();
//  }

	
	//,dependsOnMethods= {"Navi_ClickEdit"})
	
  @Test(priority=0, groups= {"Edit","Check","Home"})
  public void Navi_ClickEdit() {	 
	  ExtentLog =  extentreport.createTest("Navi_ClickEdit");
	  PageFactory.initElements(driver, HomePage.class);
	 HomePage.TextEdit.click();
	 logger.info("Edit Button Clicked in Home Page - Successful");
	 ExtentLog.log(Status.PASS, "Edit Button Clicked in Home Page - Successful");
  }
  
  @Test(priority=1,dependsOnMethods= {"Navi_ClickEdit"},groups= {"Edit"})
  @Parameters({"emailid"})
  public void test01_EmailAddress(@Optional("as198184@mygame.com") String email) {	
	  ExtentLog = extentreport.createTest("test01_EmailAddress");
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.EmailAddress.sendKeys(email);
	  ExtentLog.log(Status.PASS, email);
  }
  
  @Test(priority=2,dependsOnMethods= {"Navi_ClickEdit"},groups= {"Edit"})
  @Parameters({"Firsttext","Secondtext"})
  public void test02_AppendText(@Optional("sample1") String firsttext , @Optional("sample2")String secondtext) {
	  ExtentLog = extentreport.createTest("test02_AppendText");
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.AppendText.sendKeys(firsttext);
	  EditPage.AppendText.sendKeys(secondtext);
	  ExtentLog.log(Status.PASS, firsttext+ " " +secondtext);
  }
  
  @Test(priority=3,dependsOnMethods= {"Navi_ClickEdit"},groups= {"Edit"})
  public void test03_GetText() {	
	  ExtentLog = extentreport.createTest("test03_GetText");
	  PageFactory.initElements(driver, EditPage.class);
	  System.out.println(EditPage.GetDefaultText.getText());
	  ExtentLog.log(Status.PASS, EditPage.GetDefaultText.getText());
  }
  
  @Test(priority=4,dependsOnMethods= {"Navi_ClickEdit"},dataProvider="ProvideText",groups= {"Edit"}) 
  public void test04_ClearMe(String text) {	 
	  ExtentLog = extentreport.createTest("test04_ClearMe");
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.ClearMe.clear();
	  EditPage.ClearMe.sendKeys(text);
//	  Assert.assertFalse(true);
  }
  
  @Test(priority=5,dependsOnMethods= {"Navi_ClickEdit"},groups= {"Check"})
  public void test05_DisabledCheck() throws InterruptedException {	 
	  ExtentLog = extentreport.createTest("test05_DisabledCheck");
	  PageFactory.initElements(driver, EditPage.class);
	  System.out.println(EditPage.DisabledCheck.isDisplayed());
	  Thread.sleep(3000);
  }
  
  
  
  @DataProvider(name = "ProvideText")
  public Object[][] Provide(){
	  return new Object[][] {{"Ashok"},{"Divya"},{"Adhi"}};  
  }
  
  
  
  
  
  
  
  
}
