package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;


public class KP {
	
	public static String username = "miroslavzuce@hotmail.com";
    public static String password = "ikovolimte";
  
    
    public static final String URL = "https://www.kupujemprodajem.com/user.php?action=login";
    public static WebDriver driver;
    
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get(URL);
	  driver.manage().window().maximize();
	  }
	
  
  @Test
  public void f() {
	  driver.findElement(By.name("data[email]")).sendKeys(username);
	  driver.findElement(By.name("data[password]")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id='loginForm']/table/tbody/tr/td/div[2]/table/tbody/tr[4]/td/input")).click();
	
	  Sleeper.sleepTightInSeconds(5);
	 
	  
	 
  }
 

  @AfterClass
  public void afterClass() {
  }

}
