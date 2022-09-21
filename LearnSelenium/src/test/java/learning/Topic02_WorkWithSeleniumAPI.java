package learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_WorkWithSeleniumAPI {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	//@Test
	public void Test_01_WebBrowserMethod(){
		driver.navigate().to("https://tiki.vn/");
		System.out.println("URL page: "+driver.getCurrentUrl());
		System.out.println("Title page: "+ driver.getTitle());
		sleepInSeconds(3);
	}	
	
	//@Test
	public void Test_02_Textbox(){
		WebElement FirstNameTextBoc = driver.findElement(By.id("FirstName"));
		driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
		FirstNameTextBoc.sendKeys("auto test class");
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys("demo test");
		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();
		
	}	
	
	//@Test
	public void Test_03_DropDown(){
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		List<WebElement> selectListMonth = selectMonth.getOptions();
		for(WebElement list : selectListMonth) {
			System.out.println(list.getText());
		}
	}	
	
	//@Test
	public void Test_Alert(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert = driver.switchTo().alert();
		sleepInSeconds(3);
		alert.sendKeys("auto test");
	}
	@Test
	public void Test_Dragandrop(){
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		WebElement sourceButton = driver.findElement(By.xpath("//li[@id='fourth']"));
		WebElement targetButton = driver.findElement(By.xpath("//div[@id='shoppingCart4']//div[@class='ui-widget-content']"));
		Actions action = new Actions(driver);
        action.dragAndDrop(sourceButton, targetButton).perform();
        sleepInSeconds(3);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSeconds(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
