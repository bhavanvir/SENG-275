# Bhavanvir Rai
#### SENG 275 Assignment 1b

Functionality: Create Account <br>
Description: Users are able to register for an entirely new account, if they don't already have one, by inputting user specific information <br>
Test Cases: 
1. TC_CA_001 - createAccountValid
2. TC_CA_002 - invalidPassword
3. TC_CA_003 - wrongPostalCode
4. TC_CA_004 - emailExists

Selenium test automation code:
```
package lab05;

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
Description: Users are able to login to an existing account <br>
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
package lab05;

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
| ![image](https://user-images.githubusercontent.com/20825496/178133611-e29480e9-9338-4834-8ab9-dcba147ca2d5.png) |
| :--: |
| *TC_LF_001* |

| ![image](https://user-images.githubusercontent.com/20825496/178133615-bfad75bf-ee06-447a-8880-9c3e7b4ec269.png) |
| :--: |
| *TC_LF_002* |

| ![image](https://user-images.githubusercontent.com/20825496/178133621-59328752-2caf-4613-9896-3154a2316b30.png) |
| :--: |
| *TC_LF_003* |

| ![image](https://user-images.githubusercontent.com/20825496/178133628-85176415-93f3-4359-ac52-171b9ed39cf0.png) |
| :--: |
| *TC_LF_004* |

| ![image](https://user-images.githubusercontent.com/20825496/178133635-c6686e32-fc4e-4c72-a4a1-d2aebea9dba5.png) |
| :--: |
| *TC_LF_005* |

| ![image](https://user-images.githubusercontent.com/20825496/178133646-e04210f4-1a6e-4b39-b21c-c356f6130ed9.png) |
| :--: |
| *TC_LF_006* |

| ![image](https://user-images.githubusercontent.com/20825496/178133650-dac700ba-650b-46cd-b4ed-c7034bf3964a.png) |
| :--: |
| *TC_LF_007* |

| ![image](https://user-images.githubusercontent.com/20825496/178133655-e2279d7c-c6d1-4c87-ba40-cf73ad41f6fc.png) |
| :--: |
| *TC_LF_008* |

| ![image](https://user-images.githubusercontent.com/20825496/178133663-17e22f81-dcb4-473d-abb6-b16327c7475b.png) |
| :--: |
| *TC_LF_009* |

| ![image](https://user-images.githubusercontent.com/20825496/178133668-309a5144-b4d6-4a8c-9451-b653e03a840d.png) |
| :--: |
| *TC_LF_010* |

| ![image](https://user-images.githubusercontent.com/20825496/178133670-785e3147-f4ed-4a7a-82b2-8f06820c1a8e.png) |
| :--: |
| *TC_LF_011* |

| ![image](https://user-images.githubusercontent.com/20825496/178133674-fedc1aeb-5e98-4b52-abab-2ff39d369260.png) |
| :--: |
| *TC_LF_012* |

Functionality: Add-Edit-Remove from cart <br>
Description: Users are able to add, edit or remove items that are in their cart <br>
Test Cases: 
1. TC_ARC_001 - AddFromHome
2. TC_ARC_002 - AddFromWomen
3. TC_ARC_003 - AddFromDresses
4. TC_ARC_004 - AddFromTShirt
5. TC_ARC_005 - FromWishlist
6. TC_ARC_006 - RemoveFromCart
7. TC_ARC_007 - IncreaseQuantity
8. TC_ARC_008 - EditSize
9. TC_ARC_009 - LogOUTAndInCart
10. TC_ARC_010 - LogOutCart
11. TC_ARC_011 - LogOutRemoveCart

Selenium test automation code:
```
package lab05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddEditRemoveFromCart {
    WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhava\\Desktop\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    @Test
    public void AddFromDresses(){
        WebElement dressesButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
        dressesButton.click();

        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    @Test
    public void AddFromHome(){
        WebElement homeButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li/a/span"));
        homeButton.click();

        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    @Test
    public void AddFromTShirt(){
        WebElement tShirtsButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"));
        tShirtsButton.click();

        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    @Test
    public void AddFromWomen(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    @Test
    public void EditSize(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertTrue(browser.getPageSource().contains("Color : Orange, Size : S"));
    }

    @Test
    public void FromWishlist(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement moreButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
        moreButton.click();

        WebElement addToWishListButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/p/a"));
        addToWishListButton.click();

        browser.navigate().back();
        browser.navigate().back();

        WebElement wishListButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/ul/li/a/span"));
        wishListButton.click();

        WebElement myWishList = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[1]/a"));
        myWishList.click();

        browser.get("http://automationpractice.com/index.php?token=DC2EAF441578FD39&fc=module&module=blockwishlist&controller=view");

        WebElement viewButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div/ul/li/div/div[2]/div/div/div/a/span"));
        viewButton.click();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    @Test
    public void IncreaseQuantity(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement moreButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
        moreButton.click();

        WebElement increaseQuanitity = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]/span/i"));
        increaseQuanitity.click();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertTrue(browser.getPageSource().contains("2 Products"));
    }

    @Test
    public void LogOUTAndInCart(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement moreButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
        moreButton.click();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        WebElement signOutButton = browser.findElement(By.partialLinkText("Sign out"));
        signOutButton.click();

        WebElement signInButton1 = browser.findElement(By.partialLinkText("Sign in"));
        signInButton1.click();

        WebElement emailAddressInput = browser.findElement(By.id("email"));
        emailAddressInput.sendKeys("0e7d9_1657320851@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");

        WebElement signInButton2 = browser.findElement(By.id("SubmitLogin"));
        signInButton2.click();

        WebElement cartButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a"));
        cartButton.click();

        assertTrue(browser.getPageSource().contains("Your shopping cart is empty."));
    }

    @Test
    public void LogOutCart(){
        WebElement signOutButton = browser.findElement(By.partialLinkText("Sign out"));
        signOutButton.click();

        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement moreButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
        moreButton.click();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertTrue(browser.getPageSource().contains("1 Product"));
    }

    @Test
    public void LogOutRemoveCart(){
        WebElement signOutButton = browser.findElement(By.partialLinkText("Sign out"));
        signOutButton.click();

        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement moreButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
        moreButton.click();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        WebElement deleteItemButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));
        deleteItemButton.click();

        assertTrue(browser.getPageSource().contains("Your shopping cart is empty."));
    }

    @Test
    public void RemoveFromCart(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,500)");

        WebElement categoriesButton = browser.findElement(By.partialLinkText("Women"));
        categoriesButton.click();

        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        WebElement deleteItemButton = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));
        deleteItemButton.click();

        assertTrue(browser.getPageSource().contains("Your shopping cart is empty."));
    }
}
```
Execution screenshot for pass/fail: <br>
| ![image](https://user-images.githubusercontent.com/20825496/178133572-2e6bb68e-78a4-4d78-a4d8-59713d79932d.png) |
| :--: |
| *Add-Edit-Remove from cart* |

Execution screenshots of the web application:
|  |
| :--: |
| *TC_ARC_001* |

|  |
| :--: |
| *TC_ARC_002* |

|  |
| :--: |
| *TC_ARC_003* |

|  |
| :--: |
| *TC_ARC_004* |

|  |
| :--: |
| *TC_ARC_005* |

|  |
| :--: |
| *TC_ARC_006* |

|  |
| :--: |
| *TC_ARC_007* |

|  |
| :--: |
| *TC_ARC_008* |

|  |
| :--: |
| *TC_ARC_009* |

|  |
| :--: |
| *TC_ARC_010* |

|  |
| :--: |
| *TC_ARC_011* |
