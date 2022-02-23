package test.mvnTest.ThesisTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndEditInfoTest extends BaseThesisTest {

    @Test
    public void loginAndEditInfo(){
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
