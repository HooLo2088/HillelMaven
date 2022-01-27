package test.mvnTest.homeWork17For27;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.BaseTestSelenide;
import ua.hillel.pageObjectSelenide.DinamicLoading1PageSelenide;

public class DinamicLoadTestSelenide extends BaseTestSelenide {
    @Test
    public void dinamicLoadTestSelenide() {
        DinamicLoading1PageSelenide getTextValue = openAppSelenide()
                .goToDinamicLoadingSelenide()
                .clickExampe1()
                .clickStartButton();

        String someText = getTextValue.getText();
        Assert.assertTrue(someText.contains("Hello World!"));

    }
}
