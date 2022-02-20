package test.mvnTest.BasicTest.homeWork16For26;

import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTest;
import ua.hillel.BasicCourse.pageObjects.FileDownloadPage;


public class DownloadFileTest extends BaseTest {

    @Test
    public void downLoadFileTest() {
        FileDownloadPage fileDownloadPage = openApp()
                .goToFileDownloadPage()
                .clickDownFileTxtButton();
        fileDownloadPage.waitForFileDownload("text.txt");

    }
}
