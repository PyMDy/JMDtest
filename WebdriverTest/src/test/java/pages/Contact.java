package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Contact {
	
	WebDriver driver;
	
	@FindBy(css = "#table2 > tbody > tr:nth-child(1) > td:nth-child(2) > input[type='text']")
	WebElement name;
	
	@FindBy(id = "rinfo")
	WebElement rinformation;
	
	@FindBy(id = "rdona")
	WebElement rdonation;
	
	@FindBy(id = "radop")
	WebElement radoption;
	
	@FindBy(id = "cdona")
	WebElement checkzoo;
	
	@FindBy(id = "cadop")
	WebElement checkemail;
	
	@FindBy(name = "address_field")
	WebElement address;
	
	@FindBy(name = "postcode_field")
	WebElement postcode;
	
	@FindBy(name = "email_field")
	WebElement email;
	
	@FindBy(id = "submit_message")
	WebElement send;
	
	@FindBy(xpath = ".//*[@id='slider-1']/a")
	WebElement slider;
	
	public Contact(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputName(String imie){
		this.name.sendKeys(imie);	
	}
	public void selectInformation(){
		rinformation.click();
	}
	public void selectDonation(){
		rdonation.click();
	}
	public void selectAdoption(){
		radoption.click();
	}
	public void checkVolunteer(){
		checkzoo.click();
	}
	public void checkNewsletter(){
		checkemail.click();
	}
	public void inputAddress(String adres){
		this.address.sendKeys(adres);
	}
	public void inputPostcode(String post){
		this.postcode.sendKeys(post);
	}
	public void inputEmail(String mail){
		this.email.sendKeys(mail);
	}
	public void clickSend(){
		send.click();
	}
	public void moveDonation(int x){
		//driver.switchTo().frame(0);
		Actions builder = new Actions(driver);
		Action moveslider = builder.dragAndDropBy(slider, x, 0).build();
		moveslider.perform();
	}
	public void checkAlert() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.getText();
	        alert.accept();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}