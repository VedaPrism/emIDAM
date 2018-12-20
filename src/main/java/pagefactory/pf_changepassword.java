package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_changepassword extends pf_genericmethods {

	public pf_changepassword(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
//	Change password elements
	
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/a/span") WebElement profiletopbar;
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/ul/li[2]/a") WebElement changepassword;
	@FindBy(how = How.ID, using = "oldPassword") WebElement currentpass;
	@FindBy(how = How.ID, using = "newPassword") WebElement newpass;
	@FindBy(how = How.ID, using = "confirmPassword") WebElement confirmpass;
	@FindBy(how = How.XPATH, using = "//div[@class='pageBtnBlk']/a[1]") WebElement changepasswordbtn;
	@FindBy(how = How.XPATH, using = "//div[@class='pageBtnBlk']/a[2]") WebElement cancel;
	@FindBy(how = How.ID, using = "oldPasswordError") WebElement error;
	@FindBy(how = How.ID, using = "newPasswordError") WebElement newpasserror;
	@FindBy(how = How.ID, using = "confirmPasswordError") WebElement confirmpasserror;
	@FindBy(how = How.ID, using = "failureMSG") WebElement failuremsg;
	
	
	public void changepassword(String cp, String np, String co) throws Exception {
		
		cl_click(profiletopbar);
		Thread.sleep(2000);
		cl_click(changepassword);
		cl_click(changepasswordbtn);
		if(!(error.getText() == "")||!(newpasserror.getText() == "")||!(confirmpasserror.getText() == "")) {
			
			cl_entertext(currentpass,cp);
			cl_entertext(newpass, np);
			cl_entertext(confirmpass, co);
			cl_click(changepasswordbtn);
			Thread.sleep(3000);
			if(failuremsg.isDisplayed()) {
				System.out.println(failuremsg.getText());
			}
		}else {
			System.out.println(error.getText() +" "+newpasserror.getText() +" "+confirmpasserror.getText() );
		}
	}
	
}
