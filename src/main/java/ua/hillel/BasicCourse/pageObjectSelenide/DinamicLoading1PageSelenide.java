package ua.hillel.BasicCourse.pageObjectSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class DinamicLoading1PageSelenide {
    private final SelenideElement startButton = $("#start > button");

    private final SelenideElement text = $("#finish");

    public DinamicLoading1PageSelenide clickStartButton() {
        startButton.shouldBe(Condition.visible).click();
        return this;
    }

    public String getText() {
        return text.shouldBe(Condition.visible).getText();
    }
}
