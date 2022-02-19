package test.mvnTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ua.hillel.pageObjects.FileDownloadPage;
import ua.hillel.pageObjects.MainPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", new File("target/download").getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void after() {
        driver.quit();
    }

    @SneakyThrows
    @AfterMethod
    public void takeScreenShot(ITestResult result) {
        if (!result.isSuccess()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            saveScreenshot(Files.readAllBytes(screenshot.toPath()));
        }
    }

    public static MainPage openApp() {
        driver.get("https://the-internet.herokuapp.com");
        return new MainPage(driver);
    }

    @Attachment(value = "Page screenshot", type = "image/pgn")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
