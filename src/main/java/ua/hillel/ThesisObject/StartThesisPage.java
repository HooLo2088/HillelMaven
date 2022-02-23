package ua.hillel.ThesisObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartThesisPage {

    private final SelenideElement loginButton = $("body > app-root > div > app-home > div > div:nth-child(4) > a");
    private final SelenideElement registrationButton = $("body > app-root > div > app-home > div > div:nth-child(5) > a");

    public LoginThesisPage goToLoginPage(){
        loginButton.click();
        return new LoginThesisPage();
    }

}
