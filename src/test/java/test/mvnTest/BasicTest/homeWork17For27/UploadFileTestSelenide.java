package test.mvnTest.BasicTest.homeWork17For27;

import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTestSelenide;
import ua.hillel.BasicCourse.pageObjectSelenide.UploadFilePageSelenide;

import java.io.File;

public class UploadFileTestSelenide extends BaseTestSelenide {

    @Test
    public void uploadFileTestDelenide() {

        UploadFilePageSelenide uploadFilePageSelenide = openAppSelenide()
                .goToUploadFilePageSelenide()
                .uploadFileSelenide(new File("some-file.txt"));

    }
}