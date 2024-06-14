package CucumberFramework.StepDefinations;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Steps {
    WebDriver driver;
    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Log in'")).click();

    }
    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String userName, String password) {
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
    }
    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
    }
    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        boolean status = driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
        Assert.assertEquals(status,true);

    }
    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        boolean welcomeText=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
        Assert.assertEquals(welcomeText,"Welcome to our Page");
        driver.quit();

    }
}