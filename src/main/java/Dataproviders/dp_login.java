package Dataproviders;

import java.util.ListIterator;

import org.testng.annotations.DataProvider;

import Generic_Libraries.Utility;

public class dp_login {

	@DataProvider(name = "Valid")
	public static ListIterator<Object[]> validlogin() throws Exception {
		
		return Utility.commonlogic("Credentials","ValidLogin");
	}
	
	@DataProvider(name = "Invalid")
	public static ListIterator<Object[]> invalidlogin() throws Exception {
		
		return Utility.commonlogic("Credentials","InvalidLogin");
	}
	
}
