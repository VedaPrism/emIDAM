package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import Generic_Libraries.basicmethods;

public class pf_createAdmin extends pf_genericmethods {
	
	basicmethods b = new basicmethods();
	
//	Create Admin Elements
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'sidebar-menu']/ul/li[1]/a") WebElement adminlink;
	@FindBy(how = How.ID, using = "CreateAdmin") WebElement createadmin;
	@FindAll({@FindBy(how = How.XPATH, using = "//form[@id='enrollAdminForm']/ul[1]/li")}) public List<WebElement> createtextfields;
	@FindBy(how = How.XPATH, using = "//*[@id=\"first_name\"]") WebElement firstname;
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle_name\"]") WebElement middlename;
	@FindBy(how = How.XPATH, using = "//*[@id=\"last_name\"]") WebElement lastname;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gender\"]") WebElement gender;
	@FindBy(how = How.XPATH, using = "//*[@id=\"dateValues\"]") WebElement DOB;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mobile\"]") WebElement mobile;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement email;
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_name\"]") WebElement username;
	@FindBy(how = How.XPATH, using = "//*[@id=\"organization\"]") WebElement org;
	@FindBy(how = How.XPATH, using = "//*[@id=\"userdept\"]") WebElement dept;
	@FindBy(how = How.XPATH, using = "//*[@id=\"empId\"]") WebElement emp;
	@FindBy(how = How.XPATH, using = "//*[@id=\"role\"]") WebElement role;
	@FindBy(how = How.XPATH, using = "//*[@id=\"addressline1\"]") WebElement add1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"addressline2\"]") WebElement add2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement country;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement state;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement district;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zipcode\"]") WebElement zip;
	@FindBy(how = How.XPATH, using = "//div[@class = 'pageBtnBlk']/input") WebElement save;
	@FindBy(how = How.ID, using = "reviewAndConfirm") WebElement reviewconfirm;
	@FindBy(how = How.XPATH, using = "//*[@id=\"successMsg\"]") WebElement sumsg;
	@FindBy(how = How.XPATH, using = "//*[@id=\"newUser\"]") WebElement newadmin;
	@FindAll({@FindBy(how = How.CLASS_NAME, using = "error")}) public List<WebElement> errornotifications;
	@FindBy(how = How.ID, using = "mobileError") WebElement mobileerror;
	@FindBy(how = How.ID, using = "emailError") WebElement emailerror;
	@FindBy(how = How.ID, using = "nameError") WebElement nameerror;
	@FindBy(how = How.ID, using = "empIdError") WebElement emperror;
	
	@FindAll({@FindBy(how = How.CLASS_NAME, using = "mandatory")}) public List<WebElement> mandatoryfields;
	
	
	/*********************************** Manage Admin Elements *******************************************/
	
//	Delete elements
	@FindBy(how = How.ID, using = "ManageAdmin") WebElement manageadmin;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='clearfix']/div/div[2]/div/div[3]/div[2]/div/table/thead/tr[1]/th")}) public List<WebElement> tablecolumns;
	String ro = "//div[@class='clearfix']/div/div[2]/div/div[3]/div[2]/div/table/thead/tr[1]/th[#DELIM#]/div";
	String ma = "//div[@class='clearfix']/div/div[2]/div/div[3]/div[3]/div/table/tbody/tr[#DELIM#]/td[#DELIM#]";
	String me = "//div[@class='clearfix']/div/div[2]/div/div[3]/div[3]/div/table/tbody/tr[#DELIM#]/td[7]/ul/li[3]/a/i";
	@FindBy(how = How.XPATH, using = "//div[@id='popup']/div/div/div[2]/div/a[1]") WebElement deletepopup;
	@FindBy(how = How.XPATH, using = "//div[@id='popup']/div/div/div[2]/p/span/p/span") WebElement successmsg;
	
//	Edit elements
	String we = "//div[@class='clearfix']/div/div[2]/div/div[3]/div[3]/div/table/tbody/tr[#DELIM#]/td[7]/ul/li[1]/a/i";
	@FindBy(how = How.XPATH, using = "//div[@id='editbody']/div/form/div[4]/input[2]") WebElement cancelbtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"editbody\"]") WebElement editpopup;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='editbody']/div/form/ul[1]/li")}) public List<WebElement> edittextfields;
	@FindBy(how = How.XPATH, using = "//div[@id='editbody']/div/form/ul[1]/li[3]/input") WebElement editlastname;
	
//	Inactivate elements
	String ou = "//div[@class='clearfix']/div/div[2]/div/div[3]/div[3]/div/table/tbody/tr[#DELIM#]/td[7]/ul/li[2]/a/i";
	@FindBy(how = How.XPATH, using = "//div[@id='actionBtns']/a[1]") WebElement popupyesbtn;
	
	public pf_createAdmin(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
//	VAlues retrieved from excel
	
	
	
	public void create(String fn, String mn, String ln,String gn, String dob, String mo, String em,
						String un, String or, String de, String ep, String rl, String a1,
						String a2, String co, String st, String dt, String zi) throws Exception {
		
		Thread.sleep(3000);
		cl_click(adminlink);
		Thread.sleep(2000);
		cl_click(createadmin);
		Thread.sleep(3000);
		System.out.println("Mandatory fields are: "+mandatoryfields.size());
		/*cl_click(save);
		Thread.sleep(3000);
		System.out.println("No of error Notifications : "+errornotifications.size());
		*/int si = createtextfields.size();
		cl_entertext(firstname, fn);
		cl_entertext(middlename, mn);
		cl_entertext(lastname, ln);
		Select s = new Select(gender);
		s.selectByValue(gn);
		cl_entertext(DOB, dob);
		cl_entertext(mobile, mo);
		cl_entertext(email, em);
		cl_entertext(username,un);
		cl_entertext(org, or);
		Select s1 = new Select(dept);
		s1.selectByValue(de);
		cl_entertext(emp, ep);
		Select s2 = new Select(role);
		s2.selectByValue(rl);
		
		cl_entertext(add1, a1);
		cl_entertext(add2, a2);
		Select s3 = new Select(country);
		s3.selectByValue(co);
		Select s4 = new Select(state);
		s4.selectByValue(st);
		Select s5 = new Select(district);
		s5.selectByValue(dt);
		cl_entertext(zip,zi);
		cl_click(save);
		Thread.sleep(5000);
		if((mobileerror.isDisplayed()) ||(emailerror.isDisplayed())||(nameerror.isDisplayed())||(emperror.isDisplayed())) {
			System.out.println("Few Data inputs exists already. Pls find below : "+"\n"+mobileerror.getText()+"\n"+emailerror.getText()+"\n"+nameerror.getText()+"\n"+emperror.getText());
		}else {
		
		Thread.sleep(7000);
		cl_click(reviewconfirm);
		Thread.sleep(3000);
		System.out.println("Message is : "+sumsg.getText());
		if(newadmin.isDisplayed()) {
			System.out.println("Option to create new admin is available");
		}else {
			System.out.println("New admin button not visible");
		}
	}
	}
	
	public void manageadmin(String ud, String ed, String in, WebDriver driver) throws Exception {
		
		cl_click(manageadmin);
		Thread.sleep(3000);
		System.out.println("Table columns are : "+tablecolumns.size());
		for(int i=2;i<=tablecolumns.size();i++) {
			
//			System.out.println(basicmethods.s.findElement(By.xpath(ro.replace("#DELIM#",String.valueOf(i)))).getText());
		for(int j=1;j<=tablecolumns.size();j++) {
			
			String text = basicmethods.s.findElement(By.xpath(ma.replaceFirst("#DELIM#",String.valueOf(i)).replaceAll("#DELIM#",String.valueOf(j)))).getText();
			System.out.println(text);
			
//			Deleting the admin user
			
			if(text.equalsIgnoreCase(ud)) {
				
				cl_click(basicmethods.s.findElement(By.xpath(me.replaceFirst("#DELIM#",String.valueOf(i)))));
				Thread.sleep(3000);
				cl_click(deletepopup);
				Thread.sleep(5000);
				System.out.println(successmsg.getText());
			}
			
//			Editing the created admin user
			
			if(text.equalsIgnoreCase(ed)) {
				
				cl_click(basicmethods.s.findElement(By.xpath(we.replaceFirst("#DELIM#",String.valueOf(i)))));
				Thread.sleep(3000);
				cl_click(editpopup);
				System.out.println("Total fields : "+edittextfields.size());
				Thread.sleep(3000);
				System.out.println(editlastname.getAttribute("value"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();",cancelbtn);
				cl_click(cancelbtn);
				Thread.sleep(3000);
				
			}
			
//			Deactivating an user
			
			/*if((text.equalsIgnoreCase(in)) && ((basicmethods.s.findElement(By.xpath(ou.replaceFirst("#DELIM#",String.valueOf(i)))).getText().equalsIgnoreCase("Active"))) ) {
				
				cl_click(basicmethods.s.findElement(By.xpath(ou.replaceFirst("#DELIM#",String.valueOf(i)))));
				Thread.sleep(2000);
				cl_click(popupyesbtn);
				Thread.sleep(2000);
				System.out.println(successmsg.getText());
			}else {
			
				cl_click(basicmethods.s.findElement(By.xpath(we.replaceFirst("#DELIM#",String.valueOf(i)))));
				Thread.sleep(3000);
				cl_click(popupyesbtn);
			}
			*/
			
		}
		}
	}
}
