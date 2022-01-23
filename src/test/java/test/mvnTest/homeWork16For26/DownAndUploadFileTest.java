package test.mvnTest.homeWork16For26;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.BaseTest;
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

        File file = new File("target/download/text.txt").getAbsoluteFile();
        try {
            Path path = Paths.get("target/download/text.txt");
            Files.writeString(path, "\nЛя-ля-ля\nля-ля-ля", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUploadPage fileUploadPage = openApp().goToUploadPage();
        fileUploadPage.fileButton.sendKeys(new File("target/download/text.txt").getAbsolutePath());
        fileUploadPage.clickUpLoadButton();

        String successMessage = fileUploadPage.getSuccesMesage();
        Assert.assertTrue(successMessage.contains("File Uploaded!"));
    }
}

