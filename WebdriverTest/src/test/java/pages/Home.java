package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement; //FindBy
//import org.openqa.selenium.support.FindBy; //FindBy

public class Home {
	
	WebDriver driver;
	
	//@FindBy(name = "nav_contact") //FindBy
	//WebElement contact1; //FindBy
	By home = By.name("nav_home");
	By adoption = By.name("nav_adopt");
	By about = By.name("nav_about");
	By contact = By.name("nav_contact");
	By terms = By.xpath("//*[@id='footer_term']");
	By main = By.xpath("//*[@id='table1']/tbody/tr[4]/td/a");
	
	public Home(WebDriver driver){
		this.driver = driver;
	}
	public void clickContact(){
		driver.findElement(contact).click();
		//contact1.click(); //FindBy
	}
}
