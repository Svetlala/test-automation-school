package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementActionTest {

    WebDriver driver;

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/");
    }
    //TODO 1

    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    //TODO 2

    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    @Test
    public void testOpenContactUs() throws Exception {

        WebElement LinkContactUs = driver.findElement(By.id("contact-link"));
        LinkContactUs.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getTitle(), "Contact us - My Store");

    }

    //TODO 3
    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    @Test

    public void testInputText() {
        WebElement inptSearch = driver.findElement(By.id("search_query_top"));
        String inputText = "shirt";
        inptSearch.sendKeys(inputText);
        System.out.println(inptSearch.getAttribute("value"));
        Assert.assertEquals(inptSearch.getAttribute("value"), inputText);

        inptSearch.clear();
        inptSearch.sendKeys("summer");
        Assert.assertEquals(inptSearch.getAttribute("value"), "summer");
        inptSearch.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

        inptSearch.sendKeys("dress", Keys.ENTER);
        Assert.assertEquals(inptSearch.getAttribute("value"), "dress");


    }

    //TODO 4 - Also verify inputted text after each input action.

    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void testSearchResult() {
        WebElement inptSearch = driver.findElement(By.id("search_query_top"));
        inptSearch.sendKeys("dress", Keys.ENTER);
        Assert.assertEquals(inptSearch.getAttribute("value"), "dress");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(driver.getTitle(), "Search - My Store");

    }
    //TODO 5


}






    //TODO - tests should use new browser instance for each test method

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/

    //TODO 1


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

    //TODO 2


    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    //TODO 3


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    //TODO 4 - Also verify inputted text after each input action.


    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    //TODO 5


