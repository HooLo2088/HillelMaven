package test.mvnTest.BasicTest.homeWork16For26;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTest;
import ua.hillel.BasicCourse.pageObjects.FileUploadPage;

public class UploadTest extends BaseTest {

    @Test
    public void uploadFileTest() {
        FileUploadPage fileUploadPage = openApp()
                .goToUploadPage()
                .sendNameFile()
                .clickUpLoadButton();

        String successMessage = fileUploadPage.getSuccesMesage();
        Assert.assertTrue(successMessage.contains("File Uploaded!"));
    }
}
