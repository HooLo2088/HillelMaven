package ua.hillel.ThesisObject.UiObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JobInfoThesisPage {

    private final SelenideElement commentFilde = $(By.xpath("//textarea[@formcontrolname='message']"));
    private final SelenideElement leaveCommentButton = $("body > app-root > div > app-job > div > mat-card > div > button > span.mat-button-wrapper");
    private final SelenideElement myCommentString = $ ("body > app-root > div > app-job > div > div.comments > div > mat-card > mat-card-content > p");

    public String myNewComment(){
        return myCommentString.shouldBe(Condition.visible).getText();
    }

    public JobInfoThesisPage setComment(String comment) {
        commentFilde.shouldBe(Condition.visible).sendKeys(comment);
        return this;
    }

    public JobInfoThesisPage clickLeaveCommentsButton() {
        leaveCommentButton.shouldBe(Condition.visible).click();
        return this;
    }

    public JobInfoThesisPage setCommentAndClickButton(String comment) {
        this.setComment(comment);
        return this.clickLeaveCommentsButton();
    }


}
