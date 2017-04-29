package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	public Contact(WebDriver driver){
		this.driver = driver;
	}
	
	public void setName(String imie){
	driver.findElement(name).sendKeys(imie);	
	}
}
