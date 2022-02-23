package test.mvnTest.ThesisTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewJobThesisTest extends BaseThesisTest {

    @Test
    public void addNewJob(){
        String alert = opennApp()
                .goToLoginPage()
                .login("hoolo", "12345678")
                .goToProfilePage()
                .clickAddJobProfileButton()
                .setNewJob("NewJob", "ItIsNewJob", "123")
                .getCounterMyJob();

        Assert.assertTrue(alert.contains("You have"));

    }
}
