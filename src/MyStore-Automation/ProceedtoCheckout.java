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

public class ProceedtoCheckout {
	@BeforeClass
	public void invokeBrowser() {
		System.out.println("Creating Connection");
	}
	
	@Test
 public void ProceedToCheckout() throws InterruptedException {

  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
  WebDriver driver=new ChromeDriver();
  String URL="http://automationpractice.com/index.php";
  driver.get(URL);
  System.out.println("Webpage Opened");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
  System.out.println("Webpage Maximized");
  driver.findElement(By.linkText("Sign in")).click();
  driver.findElement(By.id("email")).sendKeys("test1249@test.com");
  driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
  driver.findElement(By.id("SubmitLogin")).click();
  System.out.println("Logged in");
  driver.findElement(By.linkText("WOMEN")).click();

  WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
  WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
  Actions actions=new Actions(driver);
  actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();
  driver.findElement(By.id("quantity_wanted")).clear();
  driver.findElement(By.id("quantity_wanted")).sendKeys("2");
  WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
  Select oSelect=new Select(Sizedrpdwn);
  oSelect.selectByVisibleText("M");
  driver.findElement(By.id("color_11")).click();
  driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
  driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");
  Thread.sleep(2000L);
  driver.findElement(By.xpath(".//*[@id='add_to_cart']/button")).click();
  System.out.println("Added to Cart");
  Thread.sleep(2000L);
  driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
  System.out.println("Proceeded to Payment");
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
  driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();
  System.out.println("Agreed to Terms and Coditions");
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
  System.out.println("Payment mode Checked");
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
  System.out.println("Order Confirmed");
  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
  if(ConfirmationText.contains("complete")) {
   System.out.println("Order Completed: Test Case Passed");
  }
  else {
   System.out.println("Order Not Successfull: Test Case Failed");
  }

 }
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Closing Connection");
	}
}