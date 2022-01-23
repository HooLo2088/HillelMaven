package ua.hillel.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileUploadPage extends BasePage {

    @FindBy(css = "#file-upload")
    public WebElement fileButton;

    @FindBy(css = "#file-submit")
    private WebElement upLoadButton;

    @FindBy(css = "#content > div > h3")
    private WebElement succsesMesage;

    public FileUploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickFileButton() {
        clickButton(fileButton);
    }

    public FileUploadPage clickUpLoadButton() {
        clickButton(upLoadButton);
        return this;
    }

    public String getSuccesMesage() {
        return succsesMesage.getText();
    }

    public FileUploadPage sendNameFile(){
        fileButton.sendKeys(new File("text").getAbsolutePath());
        return this;
    }

}
