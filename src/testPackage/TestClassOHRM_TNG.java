package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomPackage.HomePage;
import pomPackage.LogIn;

public class TestClassOHRM_TNG {

	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\Velocity Class Data\\Drivers downloaded\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@BeforeMethod
	public void Login() {
		LogIn login = new LogIn(driver);
		login.sendUserName();
		login.sendPassword();
		login.clickOnSignInButton();
	}
	
	@Test
	public void validateHomePage() {
		HomePage home = new HomePage(driver);
		home.validateAdminTab();
		home.validatePIMTab();
	}

	@AfterMethod
	public void afterMethod() {
		HomePage home = new HomePage(driver);
		home.clickOnAvtarTab();
		home.clickOnLogOut();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
