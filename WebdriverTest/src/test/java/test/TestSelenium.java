package test;

import pages.Contact;
import pages.Home;
import pages.Adoption;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
	WebDriver driver;		
	Home home;
	Contact contact;
	Adoption adoption;
	
	//String title = driver.getTitle();				 
	//assertTrue(title.contains("Contact")); 
	
	//@BeforeClass //ale musi byæ static wtedy i trzeba zaimportowaæ BeforeClass
	@Before
	public void beforeTest() {	
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://thetestroom.com/webapp"); 
	    home = new Home(driver);
		contact = new Contact(driver);
		adoption = new Adoption(driver);
	}
	
	@Test				
	public void testPositiveContact() {	
		//home = new Home(driver); //jeœli nie ma w setUp
		//contact = new Contact(driver); //jeœli nie ma w setUp
		home.clickContact();
		contact.inputName("Maciek");
		contact.checkNewsletter();
		contact.selectAdoption();
		contact.inputAddress("Test85");
		contact.inputEmail("test@o.l");
		contact.inputPostcode("67-873");
		contact.clickSend();
		w8(500);
		assertTrue(driver.getTitle().contains("Contact Confirmation"));
		//contact.moveDonation(400);
		}	
	@Test
	public void testAlertContact(){
		//home = new Home(driver); //jeœli nie ma w setUp
		//contact = new Contact(driver); //jeœli nie ma w setUp
		home.clickContact();
		contact.inputName("Maciek");
		contact.clickSend();
		contact.checkAlert();
		w8(500);
	}
	@Test
	public void testAdoption(){
		//home = new Home(driver); //jeœli nie ma w setUp
		//adoption = new Adoption(driver); //jeœli nie ma w setUp
		home.clickAdoption();
		adoption.selectList("Today");
		w8(1000);
		
	}
	
	public void w8(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//@AfterClass //ale musi byæ static wtedy i trzeba zaimportowaæ AfterClass
	@After
	public void afterTest(){
		driver.quit();
	}
}
