package ua.hillel.BasicCourse.pageObjectSelenide;

import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;

public class UploadFilePageSelenide {

    private final SelenideElement inputFile = $("#file-upload");
    private final SelenideElement uploadButton = $("#file-submit");

    public UploadFilePageSelenide uploadFileSelenide(File file) {
        inputFile.uploadFile(file);
        uploadButton.click();
        return this;
    }
}
