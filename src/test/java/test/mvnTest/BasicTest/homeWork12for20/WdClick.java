package test.mvnTest.BasicTest.homeWork12for20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WdClick {
    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void wdTest() {

        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        driver.findElement(By.cssSelector("div.large-2 a:nth-of-type(1)")).click();

        driver.findElement(By.cssSelector("div.large-2 > .alert")).click();

        driver.findElement(By.cssSelector("div.large-2 > .success")).click();

        List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
        columns.stream().map(c -> c.getText()).forEach(System.out::println);
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
