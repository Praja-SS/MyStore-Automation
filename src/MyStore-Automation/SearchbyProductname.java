package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchbyProductname {
	@BeforeClass
	public void invokeBrowser() {
		System.out.println("Creating Connection");
	}
 @Test
 public void searchProduct() throws InterruptedException{

	 System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
  WebDriver driver=new ChromeDriver();
  String URL="http://automationpractice.com/index.php";
  System.out.println("Webpage Opened");
  driver.get(URL);
  driver.manage().window().maximize();
  System.out.println("Webpage Maximized");
  Actions actions=new Actions(driver);
  driver.findElement(By.linkText("WOMEN")).click();
  WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
  actions.moveToElement(TshirtTab).click().perform();
  
  String ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
  System.out.println(ProductName);
  driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
  driver.findElement(By.name("submit_search")).click();
  System.out.println("Searched by Product Name");
  String SearchResultProductname=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
  if(ProductName.equalsIgnoreCase(SearchResultProductname)) {
   System.out.println("Results Matched;Test Case Passed");
  }else{
   System.out.println("Results NotMatched;Test Case Failed");
  }
  driver.close();
 }
 @AfterClass
	public void closeBrowser()
	{
		System.out.println("Closing Connection");
	}
}
