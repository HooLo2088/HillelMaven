package ua.hillel.ThesisObject.UiObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ProfileThesisPage {

    private final SelenideElement editProfileButton = $("body > app-root > div > app-profile > div > div:nth-child(2) > button:nth-child(1) > span.mat-button-wrapper");
    private final SelenideElement addJobProfileButton = $("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > div > button > span.mat-button-wrapper");
    private final SelenideElement editUserNameFilde = $(By.xpath("//input[@formcontrolname='name']"));
    private final SelenideElement editUserLastNameFilde = $(By.xpath("//input[@formcontrolname='lastname']"));
    private final SelenideElement updateUserInfoButton = $(By.xpath("//*[contains(text(),'Update')]"));
    private final SelenideElement newNameAndLastName = $("body > app-root > div > app-profile > div > div.row > div:nth-child(2) > h3");
    private final SelenideElement counterCommentsText = $("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > mat-card:nth-child(3) > mat-card-subtitle > mat-card-subtitle:nth-child(1)");
    private final SelenideElement removeJobButton = $("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > mat-card:nth-child(3) > mat-card-actions > button > span.mat-button-wrapper > mat-icon");

    public ProfileThesisPage clickEditProfileButton() {
        editProfileButton.click();
        return this;
    }

    public ProfileThesisPage setNewUserName(String newUserName) {
        editUserNameFilde.shouldBe(Condition.visible).doubleClick().sendKeys(newUserName);
        return this;
    }

    public ProfileThesisPage setNewLastName(String newLastName) {
        editUserLastNameFilde.shouldBe(Condition.visible).doubleClick().sendKeys(newLastName);
        return this;
    }

    public ProfileThesisPage editProfileInfo(String newUserName, String newLastName) {
        this.setNewUserName(newUserName);
        this.setNewLastName(newLastName);
        return this.clickUpdateUserInfoButton();
    }

    public ProfileThesisPage clickUpdateUserInfoButton() {
        updateUserInfoButton.shouldBe(Condition.visible).click();
        return this;
    }

    public String getEditNewNameAndLastName() {
        return newNameAndLastName.shouldBe(Condition.visible).getText();
    }

    public AddJobThesisPage clickAddJobProfileButton() {
        addJobProfileButton.click();
        return new AddJobThesisPage();
    }

    public ProfileThesisPage clickRemoveJobButton() {
        removeJobButton.shouldBe(Condition.visible).click();
        switchTo().alert().accept();
        return this;
    }

    public String counterComments() {
        return counterCommentsText.getText();
    }

}
