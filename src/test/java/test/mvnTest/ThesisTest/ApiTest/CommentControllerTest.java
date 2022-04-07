package test.mvnTest.ThesisTest.ApiTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hillel.ThesisObject.ApiObject.*;

import java.io.IOException;


public class CommentControllerTest {
    private User user;
    private Comment comment;
    public String userToken;
    public Integer jobId;

    @BeforeClass
    public void prepareUser() throws IOException {
        Faker faker = new Faker();

        user = new User();
        user.setUsername("hoolo1");
        user.setPassword("12345678");

        comment = new Comment();
        comment.setMessage(faker.gameOfThrones().dragon());

        AuthController authController = new AuthController();
        userToken = authController.login(user);

        JobController jobController = new JobController();
        jobId = jobController.getUserJob(userToken).get(1).getId();
    }

    @Test
    public void createComment() throws IOException {
        CommentController commentController = new CommentController();
        String mess = commentController.createComment(userToken, jobId, comment).getMessage();
        Assert.assertFalse(mess.isEmpty());
    }

    @Test
    public void getAllComment() throws IOException {
        CommentController commentController = new CommentController();
        String commentMess = commentController.getAllComments(userToken, jobId).get(0).getMessage();
        Assert.assertFalse(commentMess.isEmpty());
    }
}
