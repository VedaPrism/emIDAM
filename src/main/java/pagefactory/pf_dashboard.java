package pagefactory;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.Utility;
import Generic_Libraries.basicmethods;

public class pf_dashboard extends pf_genericmethods{
	
	basicmethods b = new basicmethods();
//	Dashboard webelements
	
	@FindAll({@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div")}) public List<WebElement> dbsections;
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div[1]/div/a/span") WebElement dbsection1;
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div[2]/div/a/span") WebElement dbsection2;
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div[3]/div/a/span") WebElement dbsection3;
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div[4]/div/a/span") WebElement dbsection4;
	
//	Dashboard Sidebar Elements
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='sidebar-menu']/ul/li")}) public List<WebElement> menuoptions;
	String me = "//div[@id='sidebar-menu']/ul/li[#DELIM#]/a";
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@id = 'accordion']/li[1]/div/ul/li")}) public List<WebElement> adminoptions;
	String ad = "//ul[@id = 'accordion']/li[1]/div/ul/li[#DELIM#]/a";
	@FindAll({@FindBy(how = How.ID, using = "ManageAdmin")}) public List<WebElement> manageadmin;
	@FindBy(how = How.XPATH, using = "//ul[@id = 'accordion']/li[1]/div/ul/li[1]/a") WebElement ma;
	@FindAll({@FindBy(how = How.ID, using = "manageDepartment")}) public List<WebElement> managedept;
	@FindBy(how = How.ID, using = "manageDepartment") WebElement md;
	@FindAll({@FindBy(how = How.ID, using = "manageLdapConnection")}) public List<WebElement> manageLDAP;
	@FindBy(how = How.ID, using = "manageLdapConnection") WebElement ml;
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@id = 'accordion']/li[2]/div/ul/li")}) public List<WebElement> deptoptions;
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@id = 'accordion']/li[3]/div/ul/li")}) public List<WebElement> LDAPoptions;
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@id = 'accordion']/li[5]/div/ul/li")}) public List<WebElement> Reports;
	@FindBy(how = How.XPATH, using = "//div[@class='profile_info']/h3") WebElement profilename;
	@FindBy(how = How.XPATH, using = "//div[@class='profile_info']/p") WebElement lastlogin;
	
	
	
	
	
	public pf_dashboard(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	Method for dashboard functionality
	
	public void dashboard() throws Exception {
		
		System.out.println("Profile name : "+profilename.getText());
		System.out.println("Last login : "+lastlogin.getText());
		int dbs = dbsections.size();
		System.out.println(dbsection1.getText()+" No of Apps Found");
		System.out.println(dbsection2.getText()+" No of Users Found");
		System.out.println(dbsection3.getText()+" No of Groups Found");
		System.out.println(dbsection4.getText()+" No of Policies Found");
		
//		Checking the sidebar menu
		
		Thread.sleep(2000);
		int mo = menuoptions.size();
		System.out.println("Total Menu options found : "+mo);
		for(int i=1;i<=mo;i++) {
			String na = b.s.findElement(By.xpath(me.replace("#DELIM#",String.valueOf(i)))).getText();
			System.out.println("Text is : "+na);
			Thread.sleep(7000);
			cl_click(b.s.findElement(By.xpath(me.replace("#DELIM#",String.valueOf(i)))));
			if(na.equalsIgnoreCase("  Admin")) {
				
				System.out.println(adminoptions.size());
				
				cl_click(ma);
			} else if(na.equalsIgnoreCase("  Departments")){
				
				System.out.println(deptoptions.size());
				cl_click(md);
			} else if(na.equalsIgnoreCase("  LDAP")) {
				System.out.println(LDAPoptions.size());
				cl_click(ml);
			}else if(na.equalsIgnoreCase("  Report")) {
				
			System.out.println(Reports.size());
	
		}else {
			System.out.println("Backup is selected");
			b.getScreenshot();
		}
		
	}
	}
}