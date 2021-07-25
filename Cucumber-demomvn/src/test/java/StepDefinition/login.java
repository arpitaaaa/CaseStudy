package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	WebDriver driver;

	@Given("I enter valid Url")
	public void i_enter_valid_url() {
		System.setProperty("webdriver.chrome.driver", "C://Users//ArpitaAgrawal//Desktop//SDET//JARs//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");	  
	}

	@When("I enter valid UserName {string}")
	public void i_enter_valid_user_name(String name) {
		driver.findElement(By.id("txtUsername")).sendKeys(name);
	}
	@When("I enter valid Password {string}")
	public void i_enter_valid_password(String pwd) {
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}
	@When("click Submit")
	public void click_submit() {
		driver.findElement(By.id("btnLogin")).click();
		
	}
	@Then("I should see user name {string}")
	public void i_should_see_user_name(String LoginName) throws InterruptedException {
		String actualName = driver.findElement(By.id("welcome")).getText();
		String expectedName = LoginName;
		Assert.assertEquals(expectedName, actualName);

		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]")).click();
		System.out.println("Logged Out");
		driver.close();
	}



}
