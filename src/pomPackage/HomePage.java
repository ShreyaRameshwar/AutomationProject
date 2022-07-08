package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//img[@alt='OrangeHRM']")
	WebElement OrangeHRMImage;
	
	@FindBy(xpath="//b[text()='Admin']")
	WebElement AdminTab;
	
	@FindBy(xpath="//b[text()='PIM']")
	WebElement PIMTab;
	
	@FindBy(xpath="//b[text()='Performance']")
	WebElement PerformanceTab;
	
	@FindBy(xpath="//a[text()='Employee Trackers']")
	WebElement EmployeeTrackersTab;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement Avtar;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement LogOut;
	
	public HomePage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
		wait = new WebDriverWait(driver2, Duration.ofSeconds(10));
	}
	
	public void validateOrangeHRMImage() {
		OrangeHRMImage.isDisplayed();
		System.out.println("OrangeHRM Image is displayed on HomePage: " + OrangeHRMImage.isDisplayed());
	}
	
	public void validateAdminTab() {
		Actions act = new Actions(driver);
		act.moveToElement(AdminTab).click().build().perform();
		driver.navigate().back();
	}
	
	public void validatePIMTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='PIM']")));
		PIMTab.isDisplayed();
		System.out.println("PIMTab is visible on Homepage: " + PIMTab.isDisplayed());
	}
	
	public void validatePerformanceTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Performance']")));
		Actions act = new Actions(driver);
		act.moveToElement(PerformanceTab).moveToElement(EmployeeTrackersTab).click().build().perform();
		driver.navigate().back();
		System.out.println("PerformanceTab is visible on Homepage: " + PerformanceTab.isDisplayed());
	}
	
	public void clickOnAvtarTab()
	{	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='welcome']")));
		Avtar.click();
	}
	
	public void clickOnLogOut()
	{	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
		LogOut.click();
	}
}
