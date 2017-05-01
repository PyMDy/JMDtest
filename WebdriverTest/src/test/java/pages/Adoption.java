package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Adoption {

	WebDriver driver;
	
	@FindBy(id = "start_select")
	WebElement list;
	
	@FindBy(id = "check_btn_01")
	WebElement btn1;
	
	@FindBy(id = "check_btn_02")
	WebElement btn2;
	
	public Adoption(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectList(String co){
		new Select(list).selectByVisibleText(co);
	}
	
	public void clickButton1(){
		btn1.click();
	}
	
	public void clickButton2(){
		btn2.click();
	}
	
}
