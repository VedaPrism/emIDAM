package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.basicmethods;

public class pf_reports extends pf_genericmethods {
	basicmethods b = new basicmethods();

	String attribute;
	public pf_reports(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//	Reports elements
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'sidebar-menu']/ul/li[5]/a") WebElement reports;
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@id = 'accordion']/li[5]/div/ul/li")}) public List<WebElement> reportslist;
	String re = "//ul[@id = 'accordion']/li[5]/div/ul/li[#DELIM#]/a";
	@FindBy(how = How.ID, using = "report_from_date") WebElement fromdate;
	@FindBy(how = How.XPATH, using = "//table[@class=' table-condensed']/thead/tr[1]/th[1]") WebElement previous;
	@FindBy(how = How.XPATH, using = "//table[@class=' table-condensed']/tbody/tr[2]/td[1]") WebElement dateselect;
	@FindBy(how = How.XPATH, using = "//article[@class='inner-wrap']/div[2]/div/div/div/ul/li[2]/button") WebElement search;
	@FindBy(how = How.ID, using = "report_analytics_data_tab") WebElement analyticstab;
	@FindBy(how = How.XPATH, using = "//table[@class='ui-pg-table ui-common-table ui-pager-table ']/tbody/tr/td[2]/table/tbody/tr/td[6]") WebElement nextpagebtn;
	
	
	
	
	public void report(WebDriver driver) throws Exception {
		
		cl_click(reports);
		int rm = reportslist.size();
		for(int t=1;t<=rm;t++) {
			
			cl_click(driver.findElement(By.xpath(re.replace("#DELIM#",String.valueOf(t)))));
			Thread.sleep(2000);
			cl_click(fromdate);
			for(int p=1;p<25;p++) {
				cl_click(previous);
			}
			cl_click(dateselect);
			cl_click(search);
			do {
				Thread.sleep(2000);
			cl_click(nextpagebtn);
			Thread.sleep(2000);
			attribute = nextpagebtn.getAttribute("class");
			}while(!attribute.contains("ui-state-disabled"));
			Thread.sleep(3000);
			cl_click(analyticstab);
			Thread.sleep(3000);
			b.getScreenshot();
		}
	}
}
