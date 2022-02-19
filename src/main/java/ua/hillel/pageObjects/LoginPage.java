package ua.hillel.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".flash.error")
    private WebElement errorAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Enter UserName")
    public LoginPage setUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    @Step("Enter Password")
    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click Login Button")
    public SecurePage clickLoginButton() {
        clickButton(loginButton);
        return new SecurePage(driver);
    }

    public SecurePage login(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        return this.clickLoginButton();
    }

    public String getErrorMessage() {
        return errorAlert.getText();
    }

}
