package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
public WebDriver Idriver;
WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);	
		waithelper = new WaitHelper(Idriver);
	}
	@FindBy(how =How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how =How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how =How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how =How.ID, using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how =How.ID, using = "SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how =How.ID, using = "SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how =How.XPATH, using = "//div[@role='listbox']")
	@CacheLookup
	WebElement txtCustomerRoles;
	
	@FindBy(how =How.XPATH, using = "//li[normalize-space()='Administrators']")
	@CacheLookup
	WebElement lstitemAdmin;
	
	@FindBy(how =How.XPATH, using = "///li[normalize-space()='Registered']")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(how =How.XPATH, using = "///li[normalize-space()='Guests']")
	@CacheLookup
	WebElement lstitemGuests;

	@FindBy(how =How.XPATH, using = "///li[normalize-space()='Vendors']")
	@CacheLookup
	WebElement lstitemVendors;
	
	@FindBy(how =How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how =How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how =How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how =How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how =How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void SetEmail(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void SetFirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	public void SetLastName(String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void ClickSearch()
	{
		btnSearch.click();
		//waithelper.WaitForElement(btnSearch, 30);
	}
	public int getNoOfRows()
	{
		return(tableRows.size());
	}
	
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
	boolean flag = false;
	
	for (int i=1; i<=getNoOfRows();i++)
	{
		
		String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
		System.out.println(emailid);
		
		if (emailid.equals("victoria_victoria@nopCommerce.com"))
		{
			flag = false;
		}
	}			
	return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
	boolean flag = false;
	
	for (int i=1; i<=getNoOfRows();i++)
	{
		
		String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
		String names[] = name.split(" ");
		System.out.println(names);
		
		if (name.equals("victoria") && names[1].equals("Terces"))
		{
			flag = true;
		}
	}			
	return flag;
	}
	}
