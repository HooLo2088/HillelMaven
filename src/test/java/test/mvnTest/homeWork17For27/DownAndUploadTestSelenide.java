package test.mvnTest.homeWork17For27;

import org.testng.annotations.Test;
import test.mvnTest.BaseTestSelenide;
import ua.hillel.pageObjectSelenide.DownloadFilePageSelenide;
import ua.hillel.pageObjectSelenide.FileClassSelenide;
import ua.hillel.pageObjectSelenide.UploadFilePageSelenide;

import java.io.File;
import java.io.FileNotFoundException;


public class DownAndUploadTestSelenide extends BaseTestSelenide {

    @Test
    public void downloadFileTestSelenide() {
        DownloadFilePageSelenide downloadFilePageSelenide = openAppSelenide()
                .goToDownloadFilePageSelenide();

        File downloadFile = downloadFilePageSelenide
                .downloadFile("some-file.txt");

        FileClassSelenide updateFile = new FileClassSelenide()
                .inputTextFileClass(downloadFile.getAbsolutePath());

        UploadFilePageSelenide uploadFilePageSelenide = openAppSelenide()
                .goToUploadFilePageSelenide()
                .uploadFileSelenide(downloadFile);
    }
}

