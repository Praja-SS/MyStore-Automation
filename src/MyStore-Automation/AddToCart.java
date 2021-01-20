package mystore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCart {
	@BeforeClass
	public void invokeBrowser() {
		System.out.println("Creating Connection");
	}
	@Test
	 public void cart(){
		  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  String URL="http://automationpractice.com/index.php";
		  System.out.println("Webpage Opened");
		  
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		  System.out.println("Webpage Maximized");
		  driver.findElement(By.linkText("WOMEN")).click();
		  WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
		  WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
		  Actions actions=new Actions(driver);
		  actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();
		  System.out.println("Prferred Dress Chosen");
		  driver.findElement(By.id("quantity_wanted")).clear();
		  driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		  System.out.println("Quantity Updated");
		  WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
		  Select oSelect=new Select(Sizedrpdwn);
		  oSelect.selectByVisibleText("M");
		  System.out.println("Size Selected");
		  driver.findElement(By.id("color_11")).click();
		  System.out.println("Color Selected");
		  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		  System.out.println("Added to Cart");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Closing Connection");
	}
}

