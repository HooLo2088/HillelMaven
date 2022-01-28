package test.mvnTest.homeWork17For27;

import org.testng.annotations.Test;
import test.mvnTest.BaseTestSelenide;
import ua.hillel.pageObjectSelenide.UploadFilePageSelenide;

import java.io.File;

public class UploadFileTestSelenide extends BaseTestSelenide {

    @Test
    public void uploadFileTestDelenide() {

        UploadFilePageSelenide uploadFilePageSelenide = openAppSelenide()
                .goToUploadFilePageSelenide()
                .uploadFileSelenide(new File("some-file.txt"));

    }
}