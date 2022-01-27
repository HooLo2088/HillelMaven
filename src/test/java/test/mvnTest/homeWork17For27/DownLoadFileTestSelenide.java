package test.mvnTest.homeWork17For27;

import org.testng.annotations.Test;
import test.mvnTest.BaseTestSelenide;
import ua.hillel.pageObjectSelenide.DownloadFilePageSelenide;
import java.io.File;
import java.io.FileNotFoundException;

public class DownLoadFileTestSelenide extends BaseTestSelenide {

    @Test
    public void downloadFileTestSelenide() {
        DownloadFilePageSelenide downloadFilePageSelenide = openAppSelenide()
                .goToDownloadFilePageSelenide();

        File downloadFile = downloadFilePageSelenide.downloadFile("some-file.txt");
    }
}
