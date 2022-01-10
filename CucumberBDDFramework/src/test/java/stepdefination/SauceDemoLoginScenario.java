package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginScenario {
	
	public WebDriver driver;

	@Given("user is navigating to saucedemo url")
	public void user_is_navigating_to_saucedemo_url() {
		// Write code here that turns the phrase above into concrete actions

		// Set system propeties for chrome browser
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		// Creating an instance of chrome browser
		driver=new ChromeDriver();

		// String to set the value
		String url="https://www.saucedemo.com/";

		// Launch the application
		driver.get(url);
		System.out.println("SauceDemo home page is launched sucessfully");
		
		// Maximize the browser
		driver.manage().window().maximize();
	}

	@When("username and password are valid")
	public void username_and_password_are_valid() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		System.out.println("Valid user name and password entered");
	}

	@And("click on login button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-button")).click();
		System.out.println("Click on login button");
	}

	@Then("display the products page")
	public void display_the_products_page() {
		// Write code here that turns the phrase above into concrete actions
		boolean status=driver.findElement(By.cssSelector("span.title")).isDisplayed();
		if(status){
			System.out.println("Product page is displayed");
		}

	}

	@And("close the application")
	public void close_the_application() {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
		System.out.println("Application is closed");
	}

	@When("Invalid username and password are entered")
	public void username_and_password_are_entered() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("user-name")).sendKeys("abc");
		driver.findElement(By.name("password")).sendKeys("abc");
		System.out.println("valid user name and password entered");
		System.out.println("Invalid username and password are entered");
	}

	@Then("unable to login")
	public void unable_to_login() {
		// Write code here that turns the phrase above into concrete actions
		WebElement errorMsg=driver.findElement(By.cssSelector("div.error-message-container.error"));
		System.out.println("Login failed, Error Message is " + errorMsg.getText());

	}

}
