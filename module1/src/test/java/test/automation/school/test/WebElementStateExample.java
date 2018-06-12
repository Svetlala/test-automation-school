package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementStateExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver(); //ctrl+ alt+v   new ChromeDriver()

        //      ctrl+/
//        driver.get("http://google.com");
//        WebElement inptSearch = driver.findElement(By.cssSelector("[name='q']"));
//
//        System.out.println("Search input: " + inptSearch.isDisplayed());

//        driver.get("http://the-internet.herokuapp.com/checkboxes");
//        WebElement chkbxFirstInput = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
//        System.out.println("First checkbox checked:" + chkbxFirstInput.isSelected());
//        System.out.println("First checkbox checked:" + chkbxFirstInput.getAttribute("checked"));
//
//        chkbxFirstInput.click();
//        System.out.println("First checkbox checked:" + chkbxFirstInput.getAttribute("checked"));
//
//        WebElement headerElement = driver.findElement(By.cssSelector("h3"));
//        System.out.println("Header Text" + headerElement.getText());
//
//        WebElement divSection = driver.findElement(By.cssSelector("div.example"));
//        System.out.println("Section text " + divSection);

        driver.get("https://jedwatson.github.io/react-select");
        WebElement drpdwnFirst = driver.findElement(By.cssSelector(".State-NSW"));
        System.out.println("Drop-down First enabled: " + drpdwnFirst.isEnabled());

        WebElement chckbxDisabled = driver.findElement(By.xpath("//input[following-sibling::*[text()='Disabled']]"));
        chckbxDisabled.click();

        drpdwnFirst = driver.findElement(By.cssSelector(".State-NSW"));
        System.out.println("Drop-down First enabled: " + drpdwnFirst.isEnabled());

    }
}
