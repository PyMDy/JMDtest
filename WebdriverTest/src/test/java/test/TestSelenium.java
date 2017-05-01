package test;

import pages.Contact;
import pages.Home;
import pages.Adoption;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
	static WebDriver driver;		//static jeœli @BeforeClass/@Afterclass
	static Home home;
	static Contact contact;
	static Adoption adoption;
	
	//String title = driver.getTitle();				 
	//assertTrue(title.contains("Contact")); 
	
	//@Before //wykona przed ka¿dym,nie musi byæ static wtedy i trzeba zaimportowaæ Before
	@BeforeClass
	public static void beforeTest() {	
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
		w8(500);	//TODO zamieniæ na EC
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
	//@After //wykona po ka¿dym, nie musi byæ static wtedy i trzeba zaimportowaæ After
	@AfterClass
	public static void afterTest(){
		driver.quit();
	}
}
