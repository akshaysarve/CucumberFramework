package stepdefination;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginData {
	
	public WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		// Set system propeties for chrome browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarve\\eclipse-workspace\\CucumberBDDFramework\\driver\\chromedriver.exe");

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

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String username, String password) {
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Valid user name and password are entered");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.id("login-button")).click();
		System.out.println("Click on login button");
	}

	@Then("display the product page")
	public void display_the_product_page() {
		boolean status=driver.findElement(By.cssSelector("span.title")).isDisplayed();
		if(status){
			System.out.println("Product page is displayed");
		}
	}

	@And("user will close the application")
	public void close_the_application() {
		driver.close();
		System.out.println("Application is closed");
	}
	
	
}