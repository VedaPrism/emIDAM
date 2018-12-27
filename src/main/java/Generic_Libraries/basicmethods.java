package Generic_Libraries;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class basicmethods {
	
	public static WebDriver s;
	public ExtentReports er;
	public ExtentTest et;
	String browser_type;
	
	@BeforeSuite
	public void reportgen() {
		
		er = new ExtentReports("E:\\Selenium\\Reports\\emIdam_"+get_datetimestamp()+".html", false);
		
	}


	@Parameters({"browser"})
	@BeforeTest(groups= {"SMK","UAT"})
	public void baselaunch(String btype) throws Exception {
		
		browser_type = btype;
		
		//Browser launch and selection of browser
		if(btype.equalsIgnoreCase("ff")){
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
			s = new FirefoxDriver();
			
		}else if(btype.equalsIgnoreCase("ch")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			s = new ChromeDriver();
		}
		else if(btype.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\IEDriverServer.exe");
			s = new InternetExplorerDriver();
		}
		s.manage().window().maximize();
		s.get(Utility.getprop((Utility.getprop("env"))));
		s.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@AfterTest(groups = {"SMK"})
	public void closeapp() {
		
		s.close();
		er.endTest(et);
		er.flush();
	}
	
	
	public String get_datetimestamp() {
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String fr = s.format(d);
		return fr;
	}
	
	public String getScreenshot() throws Exception {
		
		TakesScreenshot ts = (TakesScreenshot)s;
		File fl = ts.getScreenshotAs(OutputType.FILE);
		String fpath = Utility.getprop("Screenshotpath") + "_"+ get_datetimestamp() +".jpg";
		FileUtils.copyFile(fl, new File(fpath));
		return fpath;
	}
}
