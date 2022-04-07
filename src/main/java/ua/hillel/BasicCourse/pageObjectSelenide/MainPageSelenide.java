package ua.hillel.BasicCourse.pageObjectSelenide;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


public class MainPageSelenide {

    private final SelenideElement downloadFilePageButton = $("#content > ul > li:nth-child(17) > a");
    private final SelenideElement uploadFilePageButton = $("#content > ul > li:nth-child(18) > a");
    private final SelenideElement dynamicLoadingButton = $("#content > ul > li:nth-child(14) > a");

    public DownloadFilePageSelenide goToDownloadFilePageSelenide() {
        downloadFilePageButton.click();
        return new DownloadFilePageSelenide();
    }

    public UploadFilePageSelenide goToUploadFilePageSelenide() {
        uploadFilePageButton.click();
        return new UploadFilePageSelenide();
    }

    public DinamicLoadingPageSelenide goToDinamicLoadingSelenide() {
        dynamicLoadingButton.click();
        return new DinamicLoadingPageSelenide();
    }
}
