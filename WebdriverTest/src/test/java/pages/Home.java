package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	WebDriver driver;
	
	@FindBy(id = "contact_link") 
	WebElement contact; 
	
	@FindBy(name = "nav_home")
	WebElement home;
	
	@FindBy(name = "nav_adopt")
	WebElement adoption;
	
	@FindBy(name = "nav_about")
	WebElement about;
	
	@FindBy(xpath = "//*[@id='footer_term']")
	WebElement terms;
	
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[4]/td/a")
	WebElement main;
	
	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickContact(){
		contact.click(); 
	}
	public void clickAdoption(){
		adoption.click();
	}
}
