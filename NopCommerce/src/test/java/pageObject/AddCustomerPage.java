package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver Idriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	By lnkCustomers_menu =By.xpath("//img[@class='brand-image-xl logo-xl']");
	By lnkCustomers_menuitem =By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkSelectCustomer = By.xpath("//li[@class='nav-item has-treeview menu-is-opening menu-open']//li[1]//a[1]");
	By btnAddnew = By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	
	By txtcustomerRoles = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-down']//div[@role='listbox']");
	
	By lstitemAdmin = By.xpath("//li[normalize-space()='Administrators']");
	By lstitemReg = By.xpath("//li[normalize-space()='Registered']");
	By lstitemGuest = By.xpath("//li[normalize-space()='Guests']");
	By lstitemVendor = By.xpath("//li[normalize-space()='Vendors']");
	
	By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");
	By rdMaleGender= By.xpath("//label[@for='Gender_Male']");
	By rdFemaleGender= By.xpath("//label[@for='Gender_Female']");
	
	By txtFirstname = By.xpath("//input[@id='FirstName']");
	By txtLastname = By.xpath("//input[@id='LastName']");
	
	By txtDOB = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave= By.xpath("//button[@name='save']");
	
	//Action Methods
	public String getPageTitle()
	{
		return Idriver.getTitle();
	}
	
	public void clickCustomersMenu() {
		Idriver.findElement(lnkCustomers_menu).click();
	}
	public void clickCustomersMenuitem() {
		Idriver.findElement(lnkCustomers_menuitem).click();
		Idriver.findElement(lnkSelectCustomer).click();
	}
	
	public void clickOnAddnew() {
		Idriver.findElement(btnAddnew).click();
	}
	public void SetEmail(String email)
	{
		Idriver.findElement(txtEmail).sendKeys(email);
	}
	public void SetPassword(String password)
	{
		Idriver.findElement(txtPassword).sendKeys(password);
	}
	public void SetCustomerRoles(String role) throws InterruptedException
	{
		if(role.equals("Vendors"))
		{
			Idriver.findElement(By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-focused k-state-hover k-state-border-down']//div[@role='listbox']")).click();
		}
		Idriver.findElement(txtcustomerRoles).click();
		WebElement listitem;
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
		{
			listitem=Idriver.findElement(lstitemAdmin);
		}
		
		else if(role.equals("Registered"))
		{
			listitem = Idriver.findElement(lstitemReg);
		}
		else if(role.equals("Vendors"))
		{
			listitem = Idriver.findElement(lstitemVendor);
		}
		else
		{
			listitem = Idriver.findElement(lstitemGuest);
		}
		//listitem.click();
		
		JavascriptExecutor js = (JavascriptExecutor)Idriver;
		js.executeScript("arguments[0].click();", listitem);
				
		}
	public void setManagerOfVendor(String value)
	{
		Select drp= new Select(Idriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);	
	}
	public void SetGender(String gender)
	{
		if(gender.equals("Male"))
		{
			Idriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			Idriver.findElement(rdFemaleGender).click();
		}
		else
		{
			Idriver.findElement(rdMaleGender).click();	//default
		}
		
	}
	public void setFirstName(String fname)
	{
		Idriver.findElement(txtFirstname).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		Idriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void setDOB(String dob)
	{
		Idriver.findElement(txtDOB).sendKeys(dob);;
	}
	public void setCompanyName(String cname)
	{
		Idriver.findElement(txtCompanyName).sendKeys(cname);
	}
	public void setAdminContent(String content)
	{
		Idriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickSave()
	{
		Idriver.findElement(btnSave).click();
	}

}
