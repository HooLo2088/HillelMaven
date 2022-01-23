package test.mvnTest.homeWork16For26;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.BaseTest;
import ua.hillel.File.FileObject;
import ua.hillel.pageObjects.FileDownloadPage;
import ua.hillel.pageObjects.FileUploadPage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

