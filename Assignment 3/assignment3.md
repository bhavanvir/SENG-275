# Bhavanvir Rai
#### SENG 275 Assignment 1b

Functionality: Create Account <br>
Description: Users are able to register for an entirely new account, if they don't already have one, by inputting user specific information.
Test Cases: 
1. TC_CA_001 - createAccountValid
2. TC_CA_002 - invalidPassword
3. TC_CA_003 - wrongPostalCode
4. TC_CA_004 - emailExists

Selenium test automation code:
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

Execution screenshot for pass/fail: <br>
| ![image](https://user-images.githubusercontent.com/20825496/178133104-2d1b52b0-f539-48b6-8228-60ecf0297548.png) |
| :--: |
| *Create Account* |

Execution screenshots of the web application:
| ![image](https://user-images.githubusercontent.com/20825496/178133158-ecb65a6f-3393-4929-aad6-991019cb412c.png) |
| :--: |
| *TC_CA_001* |

| ![image](https://user-images.githubusercontent.com/20825496/178133309-d8b8999d-fab6-49fd-867e-55475b8e8158.png) |
| :--: |
| *TC_CA_002* |

| ![image](https://user-images.githubusercontent.com/20825496/178133303-b9b194bb-aa94-4e26-bbf9-0e638930de36.png) |
| :--: |
| *TC_CA_003* |

| ![image](https://user-images.githubusercontent.com/20825496/178133314-ccc449a9-88fa-4155-93f7-d6b340da372e.png) |
| :--: |
| *TC_CA_004* |

Functionality: Login Functionality <br>
Description: Users are able to login to an existing account.
Test Cases: 
1. TC_LF_001 - ValidCredentials
2. TC_LF_002 - InvalidCredentials
3. TC_LF_003 - ValidEmailInvalidPassword
4. TC_LF_004 - InvalidEmailValidPassword
5. TC_LF_005 - NoCredentials
6. TC_LF_006 - MultipleUnsuccessfulAttempts
7. TC_LF_007 - BrowsingBack
8. TC_LF_008 - signOutCheck
9. TC_LF_009 - passwordHidden
10. TC_LF_010 - resetLinkExists
11. TC_LF_011 - signOutWorks
12. TC_LF_012 - signOutGoBack

Selenium test automation code:
```
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LoginFunctionality {
    WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhava\\Desktop\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    @Test
    public void BrowsingBack(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        boolean loginContains = browser.getPageSource().contains("John Doe");

        WebElement homeButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li/a/span"));
        homeButton.click();

        boolean homeContains = browser.getPageSource().contains("John Doe");

        assertEquals(loginContains, homeContains);
    }

    @Test
    public void InvalidCredentials(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("wrongpassword");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    @Test
    public void InvalidEmailValidPassword(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("6f7k5_6427934692@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    @Test
    public void MultipleUnsuccessfulAttempts(){
        for(int i = 0; i < 5; i++){
            browser.get("http://automationpractice.com/index.php?controller=authentication");

            WebElement emailAddressInput = browser.findElement(By.id("email"));
            emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

            WebElement passwordInput = browser.findElement(By.id("passwd"));
            passwordInput.sendKeys("wrongpassword");

            WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
            signInButton.click();
        }

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    @Test
    public void NoCredentials(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    @Test
    public void ValidCredentials(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertEquals("My account - My Store", browser.getTitle());
    }

    @Test
    public void ValidEmailInvalidPassword(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("wrongpassword");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    @Test
    public void passwordHidden(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        assertTrue(browser.findElements(By.id("passwd")).size() > 0);
    }

    @Test
    public void resetLinkExists(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        browser.findElement(By.partialLinkText("Forgot your password")).click();
        assertEquals("Forgot your password - My Store", browser.getTitle());
    }

    @Test
    public void signOutCheck(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        boolean loginContains = browser.getPageSource().contains("John Doe");

        WebElement signOutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        signOutButton.click();

        boolean logOutContains = browser.getPageSource().contains("John Doe");

        browser.navigate().refresh();

        assertTrue(loginContains);
        assertFalse(logOutContains);
    }

    @Test
    public void signOutGoBack(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        WebElement signOutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        signOutButton.click();

        assertEquals("Login - My Store", browser.getTitle());
    }

    @Test
    public void signOutWorks(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        boolean loginContains = browser.getPageSource().contains("John Doe");

        WebElement signOutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        signOutButton.click();

        boolean logOutContains = browser.getPageSource().contains("John Doe");

        assertTrue(loginContains);
        assertFalse(logOutContains);
    }
}
```

Execution screenshot for pass/fail: <br>
| ![image](https://user-images.githubusercontent.com/20825496/178133572-2e6bb68e-78a4-4d78-a4d8-59713d79932d.png) |
| :--: |
| *Login Functionality* |

Execution screenshots of the web application:
|  |
| :--: |
| *TC_LF_001* |

|  |
| :--: |
| *TC_CA_002* |

|  |
| :--: |
| *TC_CA_003* |

|  |
| :--: |
| *TC_CA_004* |

|  |
| :--: |
| *TC_CA_005* |

|  |
| :--: |
| *TC_CA_006* |

|  |
| :--: |
| *TC_CA_007* |

|  |
| :--: |
| *TC_CA_008* |

|  |
| :--: |
| *TC_CA_009* |

|  |
| :--: |
| *TC_CA_010* |

|  |
| :--: |
| *TC_CA_011* |

|  |
| :--: |
| *TC_CA_012* |
