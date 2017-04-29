package test;

import pages.Contact;
import pages.Home;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;;

public class PodajImie {
	WebDriver driver;		
	Home home;
	Contact contact;
	@Before
	public void beforeTest() {	
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://thetestroom.com/webapp"); 
	}
	
	@Test				
	public void testNameInContact() {	
		home = new Home(driver);
		home.clickContact();
		contact = new Contact(driver);
		contact.inputName("Maciek");
		contact.moveDonation(40);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = driver.getTitle();				 
		assertTrue(title.contains("Contact")); 		
	}	
	
	@After
	public void afterTest(){
		driver.quit();
	}
}
