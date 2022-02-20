package test.mvnTest.BasicTest.homeWork13For21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserName {
    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void getUserName() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(user1);
        actions.perform();
        String UName1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();

        actions.moveToElement(user2);
        actions.perform();
        String UName2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText();

        actions.moveToElement(user3);
        actions.perform();
        String UName3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText();

        System.out.printf("%s;%n%s;%n%s;", UName1, UName2, UName3);
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
