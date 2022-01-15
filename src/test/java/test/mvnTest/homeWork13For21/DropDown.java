package test.mvnTest.homeWork13For21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown {
    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void dropDown() {

        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");

        driver.findElement(By.xpath("//li[@class='dropdown']")).click();

        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[3]/ul/li[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[3]/ul/li[1]/ul/li/a")).click();

        WebElement secondPage = driver.findElement(By.xpath("/html/body/div/div[2]/p[1]"));
        Assert.assertTrue(secondPage.getText().contains("Secondary action in the menu was clicked successfully!"), "good boy)))");
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
