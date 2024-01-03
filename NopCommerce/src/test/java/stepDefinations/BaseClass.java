package stepDefinations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddCustomerPage;
import pageObject.LoginPageObject;
import pageObject.SearchCustomerPage;

public class BaseClass {
	
	WebDriver driver;
	public LoginPageObject lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public Properties configProp;
	
	//Created for generating random unique email
	
	public static String randomestring()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
}
