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

public class pf_departments extends pf_genericmethods{
	
	public pf_departments(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	Create Department elements
	
	@FindBy(how = How.XPATH, using = "//ul[@id='accordion']/li[2]/a") WebElement departments;
	@FindBy(how = How.ID, using = "createDepartment") WebElement createdept;
	@FindBy(how = How.ID, using = "deptName") WebElement deptname;
	@FindBy(how = How.XPATH, using = "//form[@id = 'deptCreateForm']/div/div/a[1]") WebElement create;
	@FindBy(how = How.XPATH, using = "//div[@id = 'alertSuccessWindow']/div/div/div[1]/button") WebElement closebtn;
	@FindBy(how = How.ID, using = "deptNameEmpty") WebElement errormsg;
	@FindBy(how = How.ID, using = "deptNameExist") WebElement existmessage;
	
	
//	Manage departments elements
	@FindBy(how = How.ID, using = "manageDepartment") WebElement managedepartments;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='gview_allDeptList']/div[2]/div/table/thead/tr[1]/th")}) public List<WebElement> tablecolumns;
	String source = "//div[@id='gview_allDeptList']/div[2]/div/table/thead/tr[1]/th[#DELIM#]/div";
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='gview_allDeptList']/div[3]/div/table/tbody/tr")}) public List<WebElement> deptnames;
	
	String so = "//div[@id='gview_allDeptList']/div[3]/div/table/tbody/tr[#DELIM#]/td[1]";
	String ed = "//div[@id='gview_allDeptList']/div[3]/div/table/tbody/tr[#DELIM#]/td[3]/ul/li[1]/a/i";
	String del = "//div[@id='gview_allDeptList']/div[3]/div/table/tbody/tr[#DELIM#]/td[3]/ul/li[2]/a/i";
	
//	@FindBy(how = How.XPATH, using = "//form[@id='deptUpdateForm']/div/div/div/div/ul/li/label/input") WebElement edname;
	@FindBy(how = How.ID, using = "deptName") WebElement edname;
	@FindBy(how = How.XPATH, using = "//form[@id='deptUpdateForm']/div/div/div/div/div/input[3]") WebElement updatebtn;
	@FindBy(how = How.XPATH, using = "//form[@id='deptUpdateForm']/div/div/div/div/div/input[4]") WebElement cancelbtn;
	@FindBy(how = How.XPATH, using = "//div[@id='actionBtns']/button") WebElement yesbtn;
	
	
	
	
	public void createdepartment(String input) throws Exception {
		
		cl_click(departments);
		Thread.sleep(3000);
		cl_click(createdept);
		Thread.sleep(2000);
		cl_click(create);
		Thread.sleep(2000);
		if(errormsg.isDisplayed()) {
			
			System.out.println("No data entered. Please enter the value");
			cl_entertext(deptname, input);
			cl_click(create);
			if(existmessage.isDisplayed()) {
				System.out.println(existmessage.getText());
				
			}else {
			Thread.sleep(2000);
			cl_click(closebtn);
			}
		
		}
	}

	public void managedepartment(WebDriver driver, String editinput) throws Exception {
		
		cl_click(departments);
		cl_click(managedepartments);
		int f = tablecolumns.size();
		for(int i =1;i<=f;i++) {
			
			WebElement d = driver.findElement(By.xpath(source.replace("#DELIM#",String.valueOf(i))));
		System.out.println(d.getText());
		}
		int g = deptnames.size();
		System.out.println("Enter what to do? :");
		Scanner sc = new Scanner(System.in);
		String userinp = sc.nextLine();
		for(int j=1;j<=g;j++) {
			
			WebElement e = driver.findElement(By.xpath(so.replace("#DELIM#",String.valueOf(j))));
			String dn = e.getText();
			System.out.println(dn);
			if(userinp.equalsIgnoreCase("edit")) {
			if(dn.equalsIgnoreCase(editinput)) {
				
				cl_click(driver.findElement(By.xpath(ed.replace("#DELIM#",String.valueOf(j)))));
				edname.clear();
				Thread.sleep(2000);
				cl_entertext(edname, "prismone");
				cl_click(updatebtn);
			}
			}else if(dn.equalsIgnoreCase(editinput)){
				
				cl_click(driver.findElement(By.xpath(del.replace("#DELIM#",String.valueOf(j)))));
				Thread.sleep(2000);
				cl_click(yesbtn);
			}
		}
		
	}
}
