package demotest;

import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class LoginTest implements IAbstractTest {
	
	 @Test()
	    @MethodOwner(owner = "Lakshmi shree")
	    public void testLogIn()  {

	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lcwtr\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("s9rowa@mail.ru", "changeme");
	    }

	    @Test()
	    @MethodOwner(owner = "Lakshmi shree")
	    public void testInvalidEmail() {

	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.invalidEmail("wrongEmail@email.com", "changeme");

	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(loginPage.getInvalidEmailText(), "Reason: User record not found.", "Reason: User record not found.''Reason: Wrong email.");

	    }

	    @Test()
	    @MethodOwner(owner = "Lakshmi shree")
	    public void testInvalidPassword() {

	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.invalidPassword("s9rowa@mail.ru", "changemee");

	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(loginPage.getInvalidPasswordText(), "Reason: Wrong password.", "Reason: Wrong password.");

	    }

}
