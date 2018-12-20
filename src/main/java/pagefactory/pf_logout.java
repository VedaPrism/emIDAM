package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_logout extends pf_genericmethods{
	
	public pf_logout(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	Logout element
	
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/a/span") WebElement profiletopbar;
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/ul/li[4]/a") WebElement logout;
	
	public void logout() throws Exception {
		cl_click(profiletopbar);
		Thread.sleep(2000);
		cl_click(logout);
		Thread.sleep(3000);
	}

}
