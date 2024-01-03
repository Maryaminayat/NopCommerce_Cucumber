package stepDefinations;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObject.AddCustomerPage;
import pageObject.LoginPageObject;
import pageObject.SearchCustomerPage;


public class LoginSteps extends BaseClass{
	
	@Before
	public void setUp() throws IOException
	{
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		String br= configProp.getProperty("browser");
		
		if(br.equals("Chrome"))
				{
			configProp.getProperty("Chrome");
			driver = new ChromeDriver();
				}	
		else if(br.equals("firefox"))
				{
			configProp.getProperty("firefox");
			driver = new FirefoxDriver();
				}	
	}
	 
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
	
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	lp = new LoginPageObject(driver);
	   
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		
		//configProp.getProperty("testurl");
		driver.get("https://admin-demo.nopcommerce.com/login");
	    
	}

	@And("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String passsword) {
	   
		lp.setUserName(email);
		lp.setPassword(passsword);
	}

	@And("click on Login")
	public void click_on_login() {
	   
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
	    
		if (driver.getPageSource().contains("Login was unsuccessful"))
		{
		driver.close();
		Assert.assertTrue(false);
		}
		else 
		{
		Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);

	}
	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException
	{
		lp.clickLogout(); 
		Thread.sleep(3000);
	}

	@Then("Close browser")
	public void close_browser() 
	{
	   driver.close();
	}
		    
	

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	  
	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() {
		addCust.clickCustomersMenu();
	   
	}

	@When("Clicks on customer menu item")
	public void clicks_on_customer_menu_item()
	{
		addCust.clickCustomersMenuitem();
	   
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() 
	{
	 
		addCust.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
		Assert.assertEquals("Customers / nopCommerce administration", addCust.getPageTitle());
	   
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{
		String email =  randomestring()+"@gmail.com";
		addCust.SetEmail(email);
		addCust.SetPassword("test123");
		addCust.SetCustomerRoles("Guests");
		addCust.setManagerOfVendor("Vendor 2");
		addCust.SetGender("Female");
		addCust.setFirstName("Maryam");
		addCust.setLastName("Khan");
		addCust.setDOB("29/05/1987");
		addCust.setCompanyName("Testing");
		addCust.setAdminContent("Testing 123");
		
	}

	@When("Click on Save button")
	public void click_on_save_button() {
		addCust.clickSave();
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) 
	{
	   Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	   .contains("The new customer has been added successfully"));
	   driver.close();
		
	}

@When("Enter customer Email")
public void enter_customer_email() 
{
searchCust = new SearchCustomerPage(driver);
searchCust.SetEmail("victoria_victoria@nopCommerce.com");
}

@When("Click on search button")
public void click_on_search_button() 
{
	searchCust.ClickSearch();
}

@Then("User should found Email in the Search table")
public void user_should_found_email_in_the_search_table() 
{
	boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
			Assert.assertEquals(true, status);
			 driver.close();
}

@When("Enter customer First name")
public void enter_customer_first_name() {
	searchCust = new SearchCustomerPage(driver);
	searchCust.SetFirstName("Victoria");
}

@When("Enter customer Last name")
public void enter_customer_last_name() {
	searchCust.SetLastName("Terces");
	searchCust.ClickSearch();
	}


@Then("User should found name in the Search table")
public void user_should_found_name_in_the_search_table() {
	boolean status= searchCust.searchCustomerByName("Victoria Terces");
	Assert.assertEquals(true, status);
	 driver.close();
}
}
