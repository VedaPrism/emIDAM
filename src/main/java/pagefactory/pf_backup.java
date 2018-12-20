package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.Utility;

public class pf_backup extends pf_genericmethods {

	
	public pf_backup(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	Backup Elements
	
	@FindBy(how = How.ID, using = "superadminBackup") WebElement backup;
	@FindBy(how = How.XPATH, using = "//form[@id='backupForm']/div/ul[1]/li/div/label[1]") WebElement manualradio;
	@FindBy(how = How.XPATH, using = "//form[@id='backupForm']/div/ul[1]/li/div/label[2]") WebElement automaticradio;
	@FindBy(how = How.XPATH, using = "//form[@id='backupForm']/div/ul[4]/li[1]/div/label[1]") WebElement localmachineradio;
	@FindBy(how = How.XPATH, using = "//form[@id='backupForm']/div/ul[4]/li[1]/div/label[2]") WebElement remotemachineradio;
	@FindBy(how = How.ID, using = "localRestorePath") WebElement path;
	@FindBy(how = How.XPATH, using = "//div[@class='pageBtnBlk']/input") WebElement backupbtn;
	@FindBy(how = How.XPATH, using = "//div[@class='pageBtnBlk']/a") WebElement cancelbtn;
	
	
	
	
	public void backup() throws Exception {
		
		cl_click(backup);
		cl_click(manualradio);
		Thread.sleep(3000);
		cl_click(automaticradio);
		cl_click(manualradio);
		cl_click(localmachineradio);
		cl_entertext(path, Utility.getprop("backuppath"));
		Thread.sleep(3000);
		cl_click(backupbtn);
	}
}
