package ua.hillel.BasicCourse.pageObjectSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DinamicLoadingPageSelenide {

    private final SelenideElement example1 = $("#content > div > a:nth-child(5)");

    public DinamicLoading1PageSelenide clickExampe1() {
        example1.click();
        return new DinamicLoading1PageSelenide();
    }
}
