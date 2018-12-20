package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_ldap extends pf_genericmethods{

	
	public pf_ldap(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	LDAP elements
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'sidebar-menu']/ul/li[3]/a") WebElement ldap;
	@FindBy(how = How.ID, using = "createLdapConnection") WebElement createconnection;
	
//	Create connection elements
	
	@FindBy(how = How.ID, using = "connName") WebElement connectionname;
	@FindBy(how = How.ID, using = "url") WebElement url;
	@FindBy(how = How.ID, using = "containerLDAP") WebElement container;
	@FindBy(how = How.ID, using = "adminDN") WebElement admindn;
	@FindBy(how = How.ID, using = "password") WebElement password;
	@FindBy(how = How.XPATH, using = "//form[@id='ldapForm']/ul/li[6]/a[1]") WebElement testconnection;
	@FindBy(how = How.XPATH, using = "//form[@id='ldapForm']/ul/li[6]/a[2]") WebElement testsave;
	
	
//	Manage Connections Elements
	
	@FindBy(how = How.ID, using = "manageLdapConnection") WebElement manageldap;
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='allUsersList']/tbody/tr[2]/td")}) public List<WebElement> connectiondata;
	
	@FindBy(how = How.XPATH, using = "//table[@id='allUsersList']/tbody/tr[2]/td[2]") WebElement connectionnam;
	@FindBy(how = How.XPATH, using = "//table[@id='allUsersList']/tbody/tr[2]/td[5]/ul/li[1]/a/i") WebElement connectionedit;
	
	
	
	public void ldap(String cna,String ur,String ct, String ad, String ap) throws Exception {
		
		cl_click(ldap);
		Thread.sleep(3000);
		cl_click(createconnection);
		cl_entertext(connectionname, cna);
		cl_entertext(url,ur);
		cl_entertext(container, ct);
		cl_entertext(admindn, ad);
		cl_entertext(password, ap);
		
	}
	
	public void manageldap() throws Exception {
		
		cl_click(ldap);
		cl_click(manageldap);
		Thread.sleep(2000);
		String cname = connectionnam.getText();
		System.out.println(cname);
		if(cname.equalsIgnoreCase("Ldapserver")) {
			
			cl_click(connectionedit);
			Thread.sleep(3000);
		}
		
		
	}
}
