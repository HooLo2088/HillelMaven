package test.mvnTest.ThesisTest.UiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddComentThesisTest extends BaseThesisTest {

    @Test
    public void addNewComment() {
        String myCommentText = opennApp()
                .goToLoginPage()
                .login("hoolo", "12345678")
                .clickViewInfoButton()
                .setCommentAndClickButton("my new comment")
                .myNewComment();

        Assert.assertTrue(myCommentText.contains("my new comment"));
    }
}
