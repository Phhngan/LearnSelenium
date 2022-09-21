package learnTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Learn03_Annotation {
  @Test
  public void testcase1() {
	  System.out.println("Chay testcase 01");
   }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Chay before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Chay after method");
  }


  @BeforeClass
  public void beforeClass() {
	  System.out.println("Chay beforeClass method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Chay afterClass method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Chay beforeTest method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Chay afterTest method");
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
