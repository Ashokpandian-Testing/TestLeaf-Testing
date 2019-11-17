package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.EditPage;
import Pages.HomePage;

public class EditPage_Test extends TestBase {
	
//  @Test
//  public void ClickEdit() {	  
//	  HomePage.TextEdit(TestBase.driver).click();
//  }

	
	//,dependsOnMethods= {"Navi_ClickEdit"})
	
  @Test(priority=0)
  public void Navi_ClickEdit() {	 
	  PageFactory.initElements(driver, HomePage.class);
	 HomePage.TextEdit.click();
  }
  
  @Test(priority=1,dependsOnMethods= {"Navi_ClickEdit"})
  public void test01_EmailAddress() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.EmailAddress.sendKeys("as198184@gmail.com");
  }
  @Test(priority=2,dependsOnMethods= {"Navi_ClickEdit"})
  public void test02_AppendText() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.AppendText.sendKeys("<-Text Appended->");
  }
  
  @Test(priority=3,dependsOnMethods= {"Navi_ClickEdit"})
  public void test03_GetText() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  System.out.println(EditPage.GetDefaultText.getText());
  }
  
  @Test(priority=4,dependsOnMethods= {"Navi_ClickEdit"})
  public void test04_ClearMe() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.ClearMe.clear();
  }
  @Test(priority=5,dependsOnMethods= {"Navi_ClickEdit"})
  public void test05_DisabledCheck() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  System.out.println(EditPage.DisabledCheck.isDisplayed());
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
