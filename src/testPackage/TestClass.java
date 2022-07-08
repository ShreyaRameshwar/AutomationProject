package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomPackage.HomePage;
import pomPackage.LogIn;

public class TestClass {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Velocity Class Data\\Drivers downloaded\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		System.out.println("Validate Login Functionality");
		LogIn login = new LogIn(driver);
		login.VerifyUserNameField();
		login.sendUserName();
		login.sendPassword();
		login.clickOnSignInButton();
		
		System.out.println("Validate HomePage");
		HomePage home = new HomePage(driver);
		home.validateOrangeHRMImage();
		home.validateAdminTab();
		home.validatePIMTab();
		home.validatePerformanceTab();
		home.clickOnAvtarTab();
		home.clickOnLogOut();
		
	}

}
