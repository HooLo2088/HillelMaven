package test.mvnTest.ThesisTest.UiTest;

import org.testng.annotations.Test;
import test.mvnTest.ThesisTest.UiTest.BaseThesisTest;

public class RemoveJobTest extends BaseThesisTest {

    @Test
    public void removeTest(){
       String comments = opennApp()
                .goToLoginPage()
                .login("hoolo", "12345678")
                .goToProfilePage()
                .clickRemoveJobButton().counterComments();

        System.out.println(comments);


    }
}
