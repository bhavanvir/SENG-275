# Bhavanvir Rai
#### SENG 275 Assignment 1b

Functionality: 'Create Account' <br>
Description: Users are able to login to an existing account, or register for an entirely new account.
Test Cases: 
1. TC_CA_001 - createAccountValid
2. TC_CA_002 - invalidPassword
3. TC_CA_003 - wrongPostalCode
4. TC_CA_004 - emailExists

```
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccount {
    WebDriver browser;
    String emailID = generateMailinatorEmail();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhava\\Desktop\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    //Methods for generating a unique email ID with the @uvic.ca suffix
    //Source: https://stackoverflow.com/questions/45841500/generate-random-emails
    public static String getUniqueId() {
        return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
    }
    public static String generateMailinatorEmail() {
        return String.format("%s@%s", getUniqueId(), "uvic.ca");
    }

    @Test
    public void createAccountValid() {
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys(emailID);

        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        new WebDriverWait(browser, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameInput = browser.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = browser.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement addressInput = browser.findElement(By.id("address1"));
        addressInput.sendKeys("Test");

        WebElement cityInput = browser.findElement(By.id("city"));
        cityInput.sendKeys("Test");

        Select stateDropdown = new Select(browser.findElement(By.id("id_state")));
        stateDropdown.selectByIndex(1);

        WebElement postcodeInput = browser.findElement(By.id("postcode"));
        postcodeInput.sendKeys("00000");

        WebElement mobilePhoneInput = browser.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("000-000-0000");

        WebElement registerButton = browser.findElement(By.id("submitAccount"));
        registerButton.click();
    }

    @Test
    public void emailExists(){
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        new WebDriverWait(browser, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]")));
        assertTrue(browser.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]")).size() > 0);
    }

    @Test
    public void invalidPassword(){
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys(emailID);

        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        new WebDriverWait(browser, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameInput = browser.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = browser.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("test");

        WebElement addressInput = browser.findElement(By.id("address1"));
        addressInput.sendKeys("Test");

        WebElement cityInput = browser.findElement(By.id("city"));
        cityInput.sendKeys("Test");

        Select stateDropdown = new Select(browser.findElement(By.id("id_state")));
        stateDropdown.selectByIndex(1);

        WebElement postcodeInput = browser.findElement(By.id("postcode"));
        postcodeInput.sendKeys("00000");

        WebElement mobilePhoneInput = browser.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("000-000-0000");

        WebElement registerButton = browser.findElement(By.id("submitAccount"));
        registerButton.click();

        new WebDriverWait(browser, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")));
        assertTrue(browser.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    @Test
    public void wrongPostalCode(){
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys(emailID);

        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        new WebDriverWait(browser, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameInput = browser.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = browser.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement addressInput = browser.findElement(By.id("address1"));
        addressInput.sendKeys("Test");

        WebElement cityInput = browser.findElement(By.id("city"));
        cityInput.sendKeys("Test");

        Select stateDropdown = new Select(browser.findElement(By.id("id_state")));
        stateDropdown.selectByIndex(1);

        WebElement postcodeInput = browser.findElement(By.id("postcode"));
        postcodeInput.sendKeys("test");

        WebElement mobilePhoneInput = browser.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("000-000-0000");

        WebElement registerButton = browser.findElement(By.id("submitAccount"));
        registerButton.click();

        new WebDriverWait(browser, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")));
        assertTrue(browser.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }
}

```
