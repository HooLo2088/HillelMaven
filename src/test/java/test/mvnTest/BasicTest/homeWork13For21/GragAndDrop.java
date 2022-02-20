package test.mvnTest.BasicTest.homeWork13For21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GragAndDrop {
    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void drag() {

        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

        WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop);

        // second metod.
//        actions.clickAndHold(drag);
//        actions.moveToElement(drop);
//        actions.release();
        actions.perform();


        WebElement hitText = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        Assert.assertTrue(hitText.getText().contains("Dropped!"), "you are miss)))");
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
