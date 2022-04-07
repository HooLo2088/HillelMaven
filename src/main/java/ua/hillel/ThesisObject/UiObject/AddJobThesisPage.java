package ua.hillel.ThesisObject.UiObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddJobThesisPage {
    private final SelenideElement titleJobFilde = $(By.xpath("//input[@formcontrolname='title']"));
    private final SelenideElement descJobFilde = $(By.xpath("//textarea[@formcontrolname='description']"));
    private final SelenideElement priceJobFilde = $(By.xpath("//input[@formcontrolname='price']"));
    private final SelenideElement createJobButton = $("body > app-root > div > app-profile > div > div.row > app-add-job > div > form > div > button > span.mat-button-wrapper");
    private final SelenideElement counterMyJob = $("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > h2");

    public String getCounterMyJob() {
        return counterMyJob.shouldBe(Condition.visible).getText();
    }

    public AddJobThesisPage setTitleJob(String titleJob) {
        titleJobFilde.sendKeys(titleJob);
        return this;
    }

    public AddJobThesisPage setDescJob(String descJob) {
        descJobFilde.sendKeys(descJob);
        return this;
    }

    public AddJobThesisPage setPriceJob(String priceJob) {
        priceJobFilde.sendKeys(priceJob);
        return this;
    }

    public AddJobThesisPage clickCreateJobButton() {
        createJobButton.click();
        return new AddJobThesisPage();
    }

    public AddJobThesisPage setNewJob(String titleJob, String descJob, String priceJob) {
        this.setTitleJob(titleJob);
        this.setDescJob(descJob);
        this.setPriceJob(priceJob);
        return this.clickCreateJobButton();
    }
}
