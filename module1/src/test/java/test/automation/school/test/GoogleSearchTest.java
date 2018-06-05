package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_v2.39-win32/chromedriver.exe");
        driver = new ChromeDriver(); //ctrl+ alt+v   new ChromeDriver()

        driver.get("http://google.com");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void googleSearch() throws InterruptedException {

        //  driver.findElement(By.name("q"));  tozhe samoje. po teksu iskat mozhno tolko xpathom
        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        // driver.findElement(By.cssSelector("[name='q']")); + ctrl+alt+v kogda kursor na dinf Element
//     driver.findElement(By.xpath("//*[@name='q']"));

        element.sendKeys("cheese!");
        element.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> searchResultsElements = driver.findElements(By.className("g"));
        assertTrue(searchResultsElements.size()>0);


    }
}




