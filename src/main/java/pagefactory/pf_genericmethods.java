package pagefactory;

import org.openqa.selenium.WebElement;

public class pf_genericmethods {
	
	//Clicking element
	
	public void cl_click(WebElement el) {
		
		el.click();
	}

//	Entering Text
	
	public void cl_entertext(WebElement el, String in) {
		
		el.sendKeys(in);
	}
}
