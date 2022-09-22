package Assignment06_Opt1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ex1_Ex2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/dynamic-loading/");
	}

	@Test
	public void Ex1_implicitWait() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		WebElement button = driver.findElement(By.xpath("//div[@id='start']//button"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		button.click();
		Assert.assertEquals((driver.findElement(By.xpath("//h4"))).getText(), "Hello World!");
	}

	@Test
	public void Ex1_explicitWait() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='start']//button")));
		WebElement button1 = driver.findElement(By.xpath("//div[@id='start']//button"));
		button1.click();
		Assert.assertEquals((driver.findElement(By.xpath("//h4"))).getText(), "Hello World!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
