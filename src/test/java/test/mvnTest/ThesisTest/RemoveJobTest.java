package test.mvnTest.ThesisTest;

import org.testng.annotations.Test;

public class RemoveJobTest extends BaseThesisTest{

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
