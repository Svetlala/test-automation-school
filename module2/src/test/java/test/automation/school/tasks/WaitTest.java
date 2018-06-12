package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WaitTest {
    //TODO - tests should use new browser instance for each test method

    WebDriver driver;
    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver(); //ctrl+ alt+v   new ChromeDriver()
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //TODO 1
    }
    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    //TODO 3 - Use Explicit Wait without Implicit Wait

    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    @Test
    public void testChcbbxHiddenAfterRemoveImpW() {

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        WebElement btnRemove = driver.findElement(By.cssSelector("#btn"));
        btnRemove.click();

        WebElement txtItsGone = driver.findElement(By.cssSelector("#message"));

        //   WebElement progressBar = driver.findElement(By.cssSelector("#loading"));
        //   WebDriverWait wait = new WebDriverWait(driver, 5);
        //   wait.until(ExpectedConditions.invisibilityOf(progressBar));

        //  assertTrue(txtItsGone.getText().equals("It's gone!"));
        Assert.assertEquals(txtItsGone.getText(), "It's gone!");
        assertTrue(driver.findElements(By.cssSelector("#checkbox")).size() == 0);

    }

    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button

    @Test
    public void testChcbbxDisplayedAfterAddImpW() {

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        WebElement btnRemoveAdd = driver.findElement(By.cssSelector("#btn"));
        btnRemoveAdd.click();
//       WebElement progressBar = driver.findElement(By.cssSelector("#loading"));
//       WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.invisibilityOf(progressBar));
        WebElement txtItsGone = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(txtItsGone.getText(), "It's gone!");
        btnRemoveAdd.click();

        WebElement txtItsBack = driver.findElement(By.cssSelector("#message"));

//        WebElement progressBarAfterAdd = driver.findElement(By.cssSelector("#loading"));
//        wait.until(ExpectedConditions.invisibilityOf(progressBarAfterAdd));

        Assert.assertEquals(txtItsBack.getText(), "It's back!");
        System.out.println(driver.findElements(By.cssSelector("#checkbox")).size());
        assertTrue(driver.findElements(By.cssSelector("#checkbox")).size() != 0);
    }

    //TODO 4 - Use Implicit Wait without Explicit Wait
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button

    @Test
    public void testChcbbxHiddenAfterRemoveExpW() {

        WebElement btnRemove = driver.findElement(By.cssSelector("#btn"));
        btnRemove.click();
        WebElement progressBar = driver.findElement(By.cssSelector("#loading"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(progressBar));

        assertTrue(driver.findElements(By.cssSelector("#checkbox")).size() == 0);

    }

    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button

    @Test
    public void testChcbbxDisplayedAfterAddExpW() {

        WebElement btnRemoveAdd = driver.findElement(By.cssSelector("#btn"));
        btnRemoveAdd.click();
        WebElement progressBar = driver.findElement(By.cssSelector("#loading"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(progressBar));

        btnRemoveAdd.click();
        WebElement progressBarAfterAdd = driver.findElement(By.cssSelector("#loading"));
        wait.until(ExpectedConditions.invisibilityOf(progressBarAfterAdd));

        System.out.println(driver.findElements(By.cssSelector("#checkbox")).size());
        assertTrue(driver.findElements(By.cssSelector("#checkbox")).size() != 0);

    }
    //TODO 1


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

    //TODO 2

    //TODO 3 - Create TestNg Test method which
    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 3 - Use Explicit Wait without Implicit Wait

    //TODO 3


    //TODO 4 - Create TestNg Test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait

    //TODO 4


    //TODO 5 - examine both approaches! which one is better?
}

