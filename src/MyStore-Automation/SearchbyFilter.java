package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchbyFilter {
	static Actions action;
	
	@BeforeClass
	public void invokeBrowser() {
		System.out.println("Creating Connection");
	}
	@Test
	public void sort(){
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Webpage Opened");
		driver.manage().window().maximize();
		System.out.println("Webpage Maximized");
		WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		inputSearch.sendKeys("Printed");
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("Sorted the Printed ones");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,2000)","");
		String image = "2";
		WebElement searchImage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+image+"]/div/div[1]/div/a[1]/img"));
		action.moveToElement(searchImage).build().perform();
		WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()",searchImage);
		System.out.println("Image Selected");
		driver.quit();
		System.out.println("Webpage CLosed");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Closing Connection");
	}
}
