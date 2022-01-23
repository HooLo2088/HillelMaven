package test.mvnTest.homeWork16For26;

import org.testng.annotations.Test;
import test.mvnTest.BaseTest;
import ua.hillel.pageObjects.FileDownloadPage;


public class DownloadFileTest extends BaseTest {

    @Test
    public void downLoadFileTest() {
        FileDownloadPage fileDownloadPage = openApp()
                .goToFileDownloadPage()
                .clickDownFileTxtButton();
        fileDownloadPage.waitForFileDownload("text.txt");

    }
}
