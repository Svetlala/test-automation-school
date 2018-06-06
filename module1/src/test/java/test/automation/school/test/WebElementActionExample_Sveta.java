package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebElementActionExample_Sveta {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");
        WebElement inptSearch = driver.findElement(By.cssSelector("[name='q']")); //ctrl+alt+v
        inptSearch.sendKeys("apple", Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        inptSearch = driver.findElement(By.cssSelector("[name='q']")); //ctrl+alt+v
        inptSearch.clear();

        inptSearch.sendKeys("banana");
        inptSearch.sendKeys(Keys.CONTROL + "a");
        inptSearch.sendKeys("new banana");
        //driver.quit();

        List<WebElement> divSearchResults = driver.findElements(By.cssSelector(".g"));
        divSearchResults.get(0).findElement(By.cssSelector("a")).click();


    }
}
