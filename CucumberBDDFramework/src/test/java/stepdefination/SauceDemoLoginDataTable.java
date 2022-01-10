package stepdefination;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginDataTable {


	public WebDriver driver;
	@Given("user is at login page")
	public void user_is_at_login_page() {
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

	@When("user enters the credentials")
	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) {

		// For other transformations you can register a DataTableType.
		List<Map<String, String>> credentials=dataTable.asMaps(String.class, String.class);
		String username= credentials.get(0).get("userName");
		String password= credentials.get(0).get("Password");
		System.out.println(username + "," + password);
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Valid user name and password are entered");	
	}

	@And("clicks at login button")
	public void clicks_at_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-button")).click();
		System.out.println("Click on login button");	
	}

	@Then("display views product page")
	public void display_views_product_page() {
		// Write code here that turns the phrase above into concrete actions
		boolean status=driver.findElement(By.cssSelector("span.title")).isDisplayed();
		if(status){
			System.out.println("display views product page");		
		}

	}

	@And("close application")
	public void close_application() {
		driver.close();
		System.out.println("Application is closed");
	}

}
