package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class WrongPassword {
	
	public static String username = "ivecluj1";
    public static String password = "IveParola22";
    
  
    public static final String URL = "http://www.endavauniversity.com";
    
    private static WebDriver driver;

  @BeforeClass
  	public void beforeClass() {
	  
	driver = new FirefoxDriver(); 
  	driver.get(URL);
  }
  

  @Test
  	public void f() {
	  
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  Sleeper.sleepTightInSeconds(2);
	  driver.findElement(By.id("loginbtn")).click();
	  
	  Sleeper.sleepTightInSeconds(5);
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message);
	  
	  assert message.contains("Invalid login") : "Error : You are logged in";
	  
	  System.out.println("Test passed");
	  }
	  
	  
	  
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
