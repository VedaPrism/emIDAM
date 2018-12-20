package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_superadminlogin extends pf_genericmethods {

	
	@FindBy(how = How.ID, using = "username") WebElement username;
	@FindBy(how = How.ID, using = "password") WebElement password;
	@FindBy(how = How.ID, using = "loginBtn") WebElement loginbutton;
	
	
	public pf_superadminlogin(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void sal(String uname, String pass) throws Exception {
		
		Thread.sleep(3000);
		cl_click(username);
		cl_entertext(username, uname);
		cl_entertext(password, pass);
		cl_click(loginbutton);
		
	}
}
