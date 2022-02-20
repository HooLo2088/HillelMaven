package ua.hillel.BasicCourse.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage extends BasePage {

    @FindBy(linkText = "text.txt")
    private WebElement downFileTxtButton;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FileDownloadPage clickDownFileTxtButton() {
        clickButton(downFileTxtButton);
        return this;
    }

    public void waitForFileDownload(String fileName) {
        int attemp = 0;
        do {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (++attemp > 10) {
                throw new RuntimeException("File is not downloaded");
            }
        } while (!new File("target/download/" + fileName).exists());
    }

}
