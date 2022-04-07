package ua.hillel.ThesisObject.UiObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainThesisPage {

    private final SelenideElement profileIcon = $("body > app-root > div > app-navigation > mat-toolbar > button > span.mat-button-wrapper > mat-icon");
    private final SelenideElement profile = $("#mat-menu-panel-0 > div > button:nth-child(1)");
    private final SelenideElement viewInfoJobButton = $("body > app-root > div > app-index > div > mat-card:nth-child(1) > mat-card-actions > button > span.mat-button-wrapper");

    public MainThesisPage clickProfileIcon() {
        profileIcon.click();
        return this;
    }

    public ProfileThesisPage goToProfilePage() {
        clickProfileIcon().profile.shouldBe(Condition.visible).click();
        return new ProfileThesisPage();
    }

    public JobInfoThesisPage clickViewInfoButton() {
        viewInfoJobButton.shouldBe(Condition.visible).click();
        return new JobInfoThesisPage();
    }
}
