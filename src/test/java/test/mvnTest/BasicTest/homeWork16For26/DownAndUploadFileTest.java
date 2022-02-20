package test.mvnTest.BasicTest.homeWork16For26;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTest;
import ua.hillel.BasicCourse.File.FileObject;
import ua.hillel.BasicCourse.pageObjects.FileDownloadPage;
import ua.hillel.BasicCourse.pageObjects.FileUploadPage;

public class DownAndUploadFileTest extends BaseTest {

    @Test
    public void downloadFile() {

        FileDownloadPage fileDownloadPage = openApp()
                .goToFileDownloadPage()
                .clickDownFileTxtButton();
        fileDownloadPage.waitForFileDownload("text.txt");

        FileObject file = new FileObject()
                .absoluteAddress()
                .inputText();

        FileUploadPage fileUploadPage = openApp()
                .goToUploadPage()
                .sendNameFile()
                .clickUpLoadButton();

        String successMessage = fileUploadPage.getSuccesMesage();
        Assert.assertTrue(successMessage.contains("File Uploaded!"));
    }
}

