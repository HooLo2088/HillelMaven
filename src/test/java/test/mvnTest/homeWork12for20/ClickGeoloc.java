package test.mvnTest.homeWork12for20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickGeoloc {
    @Test
    public void ClickGeo() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/geolocation");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement lalitude = driver.findElement(By.xpath("//*[@id=\"lat-value\"]"));
        WebElement longitude = driver.findElement(By.xpath("//*[@id=\"long-value\"]"));
        System.out.printf("Lalitude = %s%nLongitude = %s", lalitude.getText(), longitude.getText());

        driver.quit();
    }
}
