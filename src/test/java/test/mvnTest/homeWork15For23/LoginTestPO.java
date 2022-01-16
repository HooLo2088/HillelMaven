package test.mvnTest.homeWork15For23;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestPO extends BaseTest {

    @Test
    public void loginTest() {

        String alertText = openApp()
                .goToLoginPage()
                .login("tomsmith", "SuperSecretPassword!")
                .getAlertText();

        Assert.assertTrue(alertText.contains("You logged into a secure area!"));
    }
}
