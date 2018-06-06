package test.automation.school.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class JuliemrGithubTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver(); //ctrl+ alt+v   new ChromeDriver()
        driver.get("http://juliemr.github.io/protractor-demo/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenJuliemr() {
         
        Assert.assertEquals(driver.getTitle(), "Super Calculator");
    }

    @Test
    public void testSum() {
        WebElement inptAmount1 = driver.findElement(By.cssSelector("input[ng-model='first']"));
        WebElement inptAmount2 = driver.findElement(By.cssSelector("input[ng-model='second']"));
        WebElement buttonGo = driver.findElement(By.id("gobutton"));
        inptAmount1.sendKeys("34");
        inptAmount2.sendKeys("23");
        buttonGo.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement sum = driver.findElement(By.cssSelector(".ng-binding"));
        Assert.assertEquals(sum.getText(), "57");

    }

    @Test
    public void testTestResultCount() {
        WebElement inptAmount1 = driver.findElement(By.cssSelector("input[ng-model='first']"));
        WebElement inptAmount2 = driver.findElement(By.cssSelector("input[ng-model='second']"));
        WebElement drpdwnAction = driver.findElement(By.cssSelector("[ng-options='value for (key, value) in operators']"));
        WebElement buttonGo = driver.findElement(By.id("gobutton"));

        for (int i = 0; i < 4; i = i + 1) {
            inptAmount1.sendKeys("34");
            inptAmount2.sendKeys("23");
            drpdwnAction.sendKeys("-");
            buttonGo.click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<WebElement> rowsResult = driver.findElements(By.cssSelector(".table [ng-repeat='result in memory']"));
        Assert.assertEquals(rowsResult.size(), 4);


    }
}



