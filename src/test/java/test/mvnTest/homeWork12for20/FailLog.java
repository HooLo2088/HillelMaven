package test.mvnTest.homeWork12for20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FailLog {
    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void wdLogin() {

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("BabaYaga");

        driver.findElement(By.id("password")).sendKeys("NotSecretPassword!");

        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        WebElement success = driver.findElement(By.cssSelector("#flash"));
        Assert.assertTrue(success.getText().contains("Your username is invalid!"), "Not Invalid Cred)))");
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}

