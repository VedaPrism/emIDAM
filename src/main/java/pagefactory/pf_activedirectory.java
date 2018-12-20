package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_activedirectory extends pf_genericmethods{

	
	public pf_activedirectory(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
//	Active directory Elements
	
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/a/span") WebElement profiletopbar;
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/ul/li[3]/a") WebElement activedirectory;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='gview_allUsersList']/div[2]/div/table/thead/tr/th")}) public List<WebElement> tablecolumns;
	
	
	public void activedirectorysettings() throws Exception {
	
		cl_click(profiletopbar);
		Thread.sleep(2000);
		cl_click(activedirectory);
		int he = tablecolumns.size();
		System.out.println(he);
	}
	
}
