package test.mvnTest.homeWork16For26;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.BaseTest;
import ua.hillel.pageObjects.FileUploadPage;

import java.io.File;

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
