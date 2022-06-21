package lab05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UVicTest {

    WebDriver browser;

    @BeforeEach
    public void setUp() {
        // Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhava\\Desktop\\chromedriver.exe");
        browser = new ChromeDriver();

        // Firefox
        // System.setProperty("webdriver.gecko.driver", "*****LOCATION OF YOUR WEBDRIVER*****");
        // browser = new FirefoxDriver();

        // Safari
        // browser = new SafariDriver();

        browser.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    // Your tests go here

    @Test
    public void uvicPageLoads() {
        browser.get("https://www.uvic.ca/");
        assertEquals("Home - University of Victoria", browser.getTitle());
    }

    @Test
    public void uvicSearchButtonAppears() {
        browser.get("https://www.uvic.ca/");
        WebElement searchBar = browser.findElement(By.xpath("/html/body/header/div[1]/div[2]/div/div/div[2]/a[1]"));
        assertTrue(searchBar.isEnabled());
    }

    @Test
    public void uvicSearchBoxAppears() {
        browser.get("https://www.uvic.ca/");
        WebElement searchButton = browser.findElement(By.xpath("/html/body/header/div[1]/div[2]/div/div/div[2]/a[1]"));
        searchButton.click();
        WebElement searchBar = browser.findElement(By.name("q"));
        assertTrue(searchBar.isEnabled());
    }

    @Test
    public void uvicSearchTermAppears() {
        browser.get("https://www.uvic.ca/");
        WebElement searchButton = browser.findElement(By.xpath("/html/body/header/div[1]/div[2]/div/div/div[2]/a[1]"));
        searchButton.click();
        WebElement searchBar = browser.findElement(By.xpath("/html/body/header/div[1]/div[1]/div/div/form/div/input[1]"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div[1]/div/div/form/div/input[1]")));
        searchBar.sendKeys("csc");
        assertEquals("csc", searchBar.getAttribute("value"));
    }

    @Test
    public void uvicSearchResultsAppear() {
        browser.get("https://www.uvic.ca/");
        WebElement searchButton = browser.findElement(By.xpath("/html/body/header/div[1]/div[2]/div/div/div[2]/a[1]"));
        searchButton.click();
        WebElement searchBar = browser.findElement(By.xpath("/html/body/header/div[1]/div[1]/div/div/form/div/input[1]"));
        new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div[1]/div/div/form/div/input[1]")));
        WebElement search = browser.findElement(By.xpath("/html/body/header/div[1]/div[1]/div/div/form/div/button"));
        searchBar.sendKeys("csc");
        search.click();
        new WebDriverWait(browser, 5).until(ExpectedConditions.titleIs("Search - University of Victoria"));
        assertEquals("Search - University of Victoria", browser.getTitle());
    }

    @Test
    public void uvicSearchPhoneNumber() {
        browser.get("https://www.uvic.ca/");
        assertTrue(browser.getPageSource().contains("1-250-721-7211"));
    }

}
