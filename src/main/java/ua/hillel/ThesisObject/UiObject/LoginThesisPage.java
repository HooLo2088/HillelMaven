package ua.hillel.ThesisObject.UiObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginThesisPage {

    public final SelenideElement loginFilde = $("#mat-input-0");
    public final SelenideElement passFilde = $("#mat-input-1");
    public final SelenideElement loginButton = $ ("#controls > button > span.mat-button-wrapper");

    public LoginThesisPage setUserName (String userName){
        loginFilde.sendKeys(userName);
        return this;
    }

    public LoginThesisPage setPassword(String password){
        passFilde.sendKeys(password);
        return this;
    }

    public MainThesisPage clickLoginButton(){
        loginButton.click();
        return new MainThesisPage();
    }

    public MainThesisPage login(String userName, String password){
        this.setUserName(userName);
        this.setPassword(password);
        return this.clickLoginButton();
    }
}
