package ua.hillel.BasicCourse.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurePage extends BasePage {

    private final By byAlertText = By.cssSelector(".flash.success");

    @FindBy(css = ".button.secondary.radius")
    private WebElement logoutButton;

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAlertText() {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byAlertText)).getText();
    }

    @Step("Click Logout and return to Home Page")
    public LoginPage logout() {
        this.logoutButton.click();
        return new LoginPage(driver);
    }
}
