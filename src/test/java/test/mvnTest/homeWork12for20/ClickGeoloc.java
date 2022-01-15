package test.mvnTest.homeWork12for20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClickGeoloc {
    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void ClickGeo() {

        driver.get("https://the-internet.herokuapp.com/geolocation");

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lat-value\"]")));

        WebElement lalitude = driver.findElement(By.xpath("//*[@id=\"lat-value\"]"));
        WebElement longitude = driver.findElement(By.xpath("//*[@id=\"long-value\"]"));
        System.out.printf("Lalitude = %s%nLongitude = %s", lalitude.getText(), longitude.getText());
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
