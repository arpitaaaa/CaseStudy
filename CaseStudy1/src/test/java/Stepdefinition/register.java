package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class register {

	WebDriver driver;
	@Given("I enter valid Url")
	public void i_enter_valid_url() {

		System.setProperty("webdriver.chrome.driver", "C://Users//ArpitaAgrawal//Desktop//SDET//JARs//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://elearningm1.upskills.in/");	  
	}

	@Then("I click on SignUp")
	public void i_click_on_sign_up() throws InterruptedException {	
		driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();
		Thread.sleep(3000);
	}

	@When("I enter valid FirstName {string}")
	public void i_enter_valid_first_name(String Fname) {
		driver.findElement(By.id("registration_firstname")).sendKeys(Fname);
	}

	@When("I enter valid LastName {string}")
	public void i_enter_valid_last_name(String Lname) {
		driver.findElement(By.id("registration_lastname")).sendKeys(Lname);
	}

	@When("I enter valid Email {string}")
	public void i_enter_valid_email(String Email) {
		driver.findElement(By.id("registration_email")).sendKeys(Email);
	}

	@When("I enter valid UserName {string}")
	public void i_enter_valid_user_name(String UserName) {
		driver.findElement(By.id("username")).sendKeys(UserName);
	}

	@When("I enter valid Password {string}")
	public void i_enter_valid_password(String Password) {
		driver.findElement(By.id("pass1")).sendKeys(Password);
	}

	@When("I enter valid ConfirmPassword {string}")
	public void i_enter_valid_confirm_password(String ConfirmPwd) {
		driver.findElement(By.id("pass2")).sendKeys(ConfirmPwd);
	}

	@When("I click on Register buttton")
	public void i_click_on_register_buttton() {
		driver.findElement(By.id("registration_submit")).click();
	}

	@Then("I should registered successfully with Name {string} and Email {string}")
	public void i_should_registered_successfully_with_user_name_and_email(String UserName, String ExpectedEmail) throws InterruptedException {

		String actualName = driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']/p[1]")).getText();
		String expectedName = UserName;

		Assert.assertTrue(actualName.contains(expectedName));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='#']")).click();
		String actualEmail = driver.findElement(By.xpath("//div[@class='text-center']/p")).getText();
		Assert.assertEquals(ExpectedEmail, actualEmail);


		//------------------


	}


	@Then("I should compose Mail")
	public void i_should_compose_mail() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Inbox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Compose message']")).click();
		Thread.sleep(3000);
	}

	@Then("I should enter valid details and click on send button")
	public void i_should_enter_valid_details_and_click_on_send_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("riy");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@id='select2-compose_message_users-results']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("compose_message_title")).sendKeys("Testing Subject");
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys("Hi").build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("compose_message_compose")).click();
		Thread.sleep(3000);
	}

	@Then("I should see acknowledgement message")
	public void i_should_see_acknowledgement_message() {
		String ActualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String ExpectedMsg = "The message has been sent to riya raj (1234)" ;
		Assert.assertEquals(ActualMsg, ExpectedMsg);	

		driver.close();
	}

}
