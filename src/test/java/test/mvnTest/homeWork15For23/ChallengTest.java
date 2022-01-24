package test.mvnTest.homeWork15For23;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.mvnTest.BaseTest;
import ua.hillel.pageObjects.ChallengPage;

public class ChallengTest extends BaseTest {

    @Test
    public void challengTest() {
        ChallengPage challengPage = openApp()
                .goToChallengPage()
                .clickBlueButton()
                .clickRedButton()
                .clickGreenButton();

        challengPage.getText4Colums()
                .stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }
}
