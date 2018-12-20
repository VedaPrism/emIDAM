package pagefactory;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_profile extends pf_genericmethods{

	
	public pf_profile(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	Profile section elements
	
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/a/span") WebElement profiletopbar;
	@FindBy(how = How.XPATH, using = "//header[@class='clearfix page-topbar']/div[2]/div[2]/ul/li/ul/li[1]/a") WebElement profile;
	@FindBy(how = How.ID, using = "firstname") WebElement firstname;
	@FindBy(how = How.ID, using = "middlename") WebElement middlename;
	@FindBy(how = How.ID, using = "lastname") WebElement lastname;
	@FindBy(how = How.ID, using = "gender") WebElement gender;
	@FindBy(how = How.ID, using = "dateValues") WebElement dob;
	@FindBy(how = How.ID, using = "mobile") WebElement mobile;
	@FindBy(how = How.ID, using = "email") WebElement email;
	@FindBy(how = How.ID, using = "username") WebElement username;
	@FindBy(how = How.ID, using = "organization") WebElement organization;
	@FindBy(how = How.ID, using = "empId") WebElement empId;
	@FindBy(how = How.ID, using = "addressline1") WebElement addressline1;
	@FindBy(how = How.ID, using = "addressline2") WebElement addressline2;
	@FindBy(how = How.ID, using = "country") WebElement country;
	@FindBy(how = How.ID, using = "state") WebElement state;
	@FindBy(how = How.ID, using = "city") WebElement city;
	@FindBy(how = How.ID, using = "zipcode") WebElement zipcode;
	@FindBy(how = How.ID, using = "updateBtn") WebElement updatebtn;
	@FindBy(how = How.XPATH, using = "//div[@class='pageBtnBlk']/a") WebElement cancelbtn;
	@FindAll({@FindBy(how = How.XPATH, using = "//form[@id='enrollUserForm']/ul")}) public List<WebElement> profilesections;
	@FindAll({@FindBy(how = How.XPATH, using = "//form[@id='enrollUserForm']/ul[1]/li")}) public List<WebElement> profilefields; 
	
	String sections = "//form[@id='enrollUserForm']/ul[#DELIM#]/li";
	String fields = "//form[@id='enrollUserForm']/ul[#DELIM#]/li[#DELIM#]/label";
	String fields1 = "//form[@id='enrollUserForm']/ul[#DELIM#]/li[#DELIM#]/input";
	
	
	public void profilepage(WebDriver driver) throws Exception {
		
		cl_click(profiletopbar);
		Thread.sleep(2000);
		cl_click(profile);
		int pss = profilesections.size();
		System.out.println("Please enter your choice (Change/No) : ");
		Scanner sc = new Scanner(System.in);
		String nl = sc.nextLine();
		if(nl.equalsIgnoreCase("change")) {
			
			System.out.println("Which field should be changed :");
			Scanner sc1 = new Scanner(System.in);
			String fc = sc1.nextLine();
			System.out.println("Please input the value :");
			Scanner sc2 = new Scanner(System.in);
			String fc1 = sc1.nextLine();
			for(int a=1;a<=pss;a++) {
			int ps = driver.findElements(By.xpath(sections.replace("#DELIM#",String.valueOf(a)))).size();
			for(int i=1;i<=ps;i++) {
				
				String label = driver.findElement(By.xpath(fields.replaceFirst("#DELIM#",String.valueOf(a)).replace("#DELIM#",String.valueOf(i)))).getText();
				System.out.println(label);
				if(label.contains(fc)) {
					
					driver.findElement(By.xpath(fields1.replaceFirst("#DELIM#",String.valueOf(a)).replace("#DELIM#",String.valueOf(i)))).clear();
					cl_entertext(driver.findElement(By.xpath(fields1.replaceFirst("#DELIM#",String.valueOf(a)).replace("#DELIM#",String.valueOf(i)))),fc1);
					cl_click(updatebtn);
					Thread.sleep(3000);
			}
					}
		}
		}else {
			cl_click(cancelbtn);
		}
	}
	
	
	
}
