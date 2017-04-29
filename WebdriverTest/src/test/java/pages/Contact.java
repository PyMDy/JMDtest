package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Contact {
	
	WebDriver driver;
	
	By name = By.cssSelector("#table2 > tbody > tr:nth-child(1) > td:nth-child(2) > input[type='text']");
	By rinformation = By.id("rinfo");
	By rdonation = By.id("rdona");
	By radoption = By.id("radop");
	By checkzoo = By.id("cdona");
	By checkemail = By.id("cadop");
	By address = By.name("address_field");
	By postcode = By.name("postcode_field");
	By email = By.name("email_field");
	By send = By.id("submit_message");
	By slider = By.xpath(".//*[@id='slider-1']/a");
	
	public Contact(WebDriver driver){
		this.driver = driver;
	}
	
	public void inputName(String imie){
		driver.findElement(name).sendKeys(imie);	
	}
	public void selectInformation(){
		driver.findElement(rinformation).click();
	}
	public void selectDonation(){
		driver.findElement(rdonation).click();
	}
	public void selectAdoption(){
		driver.findElement(radoption).click();
	}
	public void checkVolunteer(){
		driver.findElement(checkzoo).click();
	}
	public void checkNewsletter(){
		driver.findElement(checkemail).click();
	}
	public void inputAddress(String adres){
		driver.findElement(address).sendKeys(adres);
	}
	public void inputPostcode(String post){
		driver.findElement(postcode).sendKeys(post);
	}
	public void inputEmail(String mail){
		driver.findElement(email).sendKeys(mail);
	}
	public void clickSend(){
		driver.findElement(send).click();
	}
	public void moveDonation(int x){
		Actions builder = new Actions(driver);
		Action moveslider = (Action) builder.dragAndDropBy(driver.findElement(slider), x, 0);
		moveslider.perform();
	}
}