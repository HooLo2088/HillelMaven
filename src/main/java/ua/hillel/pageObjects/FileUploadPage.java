package ua.hillel.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void clickUpLoadButton() {
        clickButton(upLoadButton);
    }

    public String getSuccesMesage() {
        return succsesMesage.getText();
    }

}
