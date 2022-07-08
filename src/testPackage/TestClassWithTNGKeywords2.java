package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassWithTNGKeywords2 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test (enabled = false) //(enabled=false) this means this method is disabled and will not run/get Executed. 
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test (timeOut=2000)   // (timeOut=2000) this means this method will wait for 2 seconds and in 2 seconds if elements are not visible then it will show "ThreadTimeoutException" "test2() didn't finish within the time-out 2000"
	public void test2() throws InterruptedException {
		System.out.println("Test2");
		Thread.sleep(3000); // here thread is added only for checking the working of "timeOut" keyword 
	}
	
	@Test (priority=2)
	public void test3() {
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
		
}
