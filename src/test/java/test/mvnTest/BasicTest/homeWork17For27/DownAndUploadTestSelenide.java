package test.mvnTest.BasicTest.homeWork17For27;

import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTestSelenide;
import ua.hillel.BasicCourse.pageObjectSelenide.DownloadFilePageSelenide;
import ua.hillel.BasicCourse.pageObjectSelenide.FileClassSelenide;
import ua.hillel.BasicCourse.pageObjectSelenide.UploadFilePageSelenide;

import java.io.File;


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

