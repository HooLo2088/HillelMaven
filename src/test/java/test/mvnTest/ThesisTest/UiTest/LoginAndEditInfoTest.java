package test.mvnTest.ThesisTest.UiTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.mvnTest.ThesisTest.UiTest.BaseThesisTest;

public class LoginAndEditInfoTest extends BaseThesisTest {

    @Test
    public void loginAndEditInfo() {
        String alertNewInfo = opennApp()
                .goToLoginPage()
                .login("hoolo", "12345678")
                .goToProfilePage()
                .clickEditProfileButton()
                .editProfileInfo("newName", "newLastName")
                .getEditNewNameAndLastName();

        Assert.assertTrue(alertNewInfo.contains("newName newLastName"));

    }
}
