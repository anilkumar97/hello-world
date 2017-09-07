package cucumberJava;



import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class CucumberJava {
	WebDriver driver = null;
	String userName ="Admin";
	String password = "admin";
	   @Given("^I have open the browser$")
	   public void openBrowser() { 
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manoj\\Desktop\\Anil kumar\\drivers\\chromedriver.exe");
	    	driver = new ChromeDriver();
	   } 
		
	   @When("^I open HRM Login Page$")
	   public void gotoHRMLogin_Page() { 
	      driver.get("http://opensource.demo.orangehrmlive.com/"); 
	   } 
		
	   @Then("^I enter UserName,Password and clicked on Login$")
	   public void enterCredentials() { 
	      driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(userName);
	      driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
	      driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
	   } 
	   @Then("^I Verify HomePage$")
	   public void verify_HomePage() {
		   String currentUrl = driver.getCurrentUrl();
		   String ExpectedURL="http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		   Assert.assertEquals(ExpectedURL, currentUrl);
		   System.out.println(currentUrl);
	   }
	   @And("^I close Browser$")
	   public void closeBrowser() {
		   driver.close();
	   }
}
