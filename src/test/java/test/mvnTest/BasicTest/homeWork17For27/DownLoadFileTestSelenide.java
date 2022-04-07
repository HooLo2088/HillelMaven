package test.mvnTest.BasicTest.homeWork17For27;

import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTestSelenide;
import ua.hillel.BasicCourse.pageObjectSelenide.DownloadFilePageSelenide;
import java.io.File;

public class DownLoadFileTestSelenide extends BaseTestSelenide {

    @Test
    public void downloadFileTestSelenide() {
        DownloadFilePageSelenide downloadFilePageSelenide = openAppSelenide()
                .goToDownloadFilePageSelenide();

        File downloadFile = downloadFilePageSelenide.downloadFile("some-file.txt");
    }
}
