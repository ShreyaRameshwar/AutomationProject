package testPackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassWithTNGKeywords1 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test (dependsOnMethods= {"test3", "test2"})    // "dependsOnMethods" this keyword willshow the dependency of this test case on other methods, if dependency is on more than one method then , if any one method get failed then this test case will not get executed
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test (priority=2, invocationCount=3)   // "invocationCount" - using this keyword we can execute same test case multiple times
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test (priority=1)     // "priority" this keyword will set the preference of execution of all the test cases 
	public void test3() {
		//Assert.fail(); // here directly this 'test3' method will get failed
		System.out.println("Test3");
		Assert.fail();   //here once it will get executed and then get failed due to "Assert.fail()"
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
