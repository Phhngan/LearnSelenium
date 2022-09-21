package HW_05;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Ex01 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
	}

	@Test
	public void Test_Bai1_DragAndDrop(){
		WebElement sourceButton = driver.findElement(By.xpath("//li[@id='fourth']"));
		WebElement targetButton = driver.findElement(By.xpath("//div[@id='shoppingCart4']//div[@class='ui-widget-content']"));
		Actions action = new Actions(driver);
        action.dragAndDrop(sourceButton, targetButton).perform();
        sleepInSeconds(3);
	}
	
	@Test
	public void Test_Bai2_DoubleClick() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		Actions action = new Actions(driver);
		action.doubleClick(button).perform();		
		sleepInSeconds(3);
		Alert alert = driver.switchTo().alert();
		sleepInSeconds(3);
        alert.accept();
	}	
	
	@Test
	public void Test_Bai3_Click() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action = new Actions(driver);
		action.contextClick(button).perform();	
		sleepInSeconds(3);
		WebElement btnEdit = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
		Actions action1 = new Actions(driver);
		action1.click(btnEdit).perform();
		sleepInSeconds(3);
		Alert alert = driver.switchTo().alert();
		sleepInSeconds(3);
        alert.accept();
	}	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSeconds(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
